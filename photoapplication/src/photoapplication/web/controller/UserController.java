package photoapplication.web.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import photoapplication.config.Constants;
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
		modelAndView.addAllObjects(daoObjectAsMap(getCurrentUser()));
		return modelAndView;
	}
	
	

	private Map<String, ?> daoObjectAsMap(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		String className = clazz.getSimpleName();
		Map map = new HashMap<>();
		for(Field field: fields){
			field.setAccessible(true);
			map.put(className+"."+field.getName(), field.get(obj));
		}
		return map;
	}



	private ImageUser getCurrentUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		ImageUser user = userService.findByEmail(userName);
		return user;
	}

	@RequestMapping(value = "/gallery", method = RequestMethod.GET)
	public ModelAndView getGallery() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
	
	@RequestMapping(value = "/gallery/images", method = RequestMethod.GET)
	public ModelAndView getGalleryImages() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}
