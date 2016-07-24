package photoapplication.web.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import photoapplication.config.Constants;
import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.ImageService;
import photoapplication.database.service.ImageUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ImageUserService userService;

	@Autowired
	private ImageService imageService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getHomePage() throws IllegalArgumentException, IllegalAccessException {
		ModelAndView modelAndView = new ModelAndView(Constants.USER_PAGE);
		modelAndView.addObject("user", getCurrentUser());
		return modelAndView;
	}

	private ImageUser getCurrentUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		ImageUser user = userService.findByEmail(userName);
		return user;
	}

	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public ModelAndView getGallery() {
		ModelAndView modelAndView = new ModelAndView(Constants.GALERY_PAGE);
		return modelAndView;
	}

	@RequestMapping(value = "/gallery/images", method = RequestMethod.POST)
	public @ResponseBody List<String> getGalleryImages() {
		ImageUser user = getCurrentUser();
		return getUserImageURL(user);
	}

	private List<String> getUserImageURL(ImageUser user) {
		List<Image> images = imageService.getByUser(user);
		if (images == null)
			return Collections.emptyList();
		return getImagesUrl(images);
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String uploadImage(MultipartHttpServletRequest request) {
		ImageUser user = getCurrentUser();
		Map<String, MultipartFile> it = request.getFileMap();
		uploadImages(user, it);
		return "upload_success";
	}

	private void uploadImages(ImageUser user, Map<String, MultipartFile> map){
		map.forEach((name, file) -> {
			Image image = new Image();
			image.setUser(user);
			image.setName(name);
			try {
				imageService.addImage(image, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	private List<String> getImagesUrl(List<Image> images) {
		return images.stream().map(image -> imageService.getImageUrl(image)).collect(Collectors.toList());
	}
}
