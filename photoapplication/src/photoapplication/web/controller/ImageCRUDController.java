package photoapplication.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static photoapplication.config.Constants.FILE;
import static photoapplication.config.Constants.FILENAME;
import static photoapplication.config.Constants.UPLOAD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import photoapplication.database.entity.Image;
import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.ImageService;
import utils.TestUtils;

@Controller
@RequestMapping("photo")
public class ImageCRUDController {

	private static final int LENGTH_OF_GENERATED_STRING = 10;
	
	public static String ifNullGenerateString(String fileName) {
		if (fileName == null) {
			fileName = TestUtils.getRandomIntegerString(LENGTH_OF_GENERATED_STRING);
		}
		return fileName;
	}

	private static String makeUniqueName(String fileName) {
		return fileName;
	}
	
	@Autowired
	@Qualifier("testImageDAO")
	private ImageService imageService;

	@ResponseBody
	@RequestMapping(method = GET)
	public  List<Image> getPhotos(){
		List<Image> images = imageService.getByUser(new ImageUser());
		return images;
	}
	
	@ResponseBody
	@RequestMapping(value="min",method = GET)
	public  String getMinituresPhotos(){
		return "";
	}

	private String normalizeFileName(String fileName) {
		fileName = ifNullGenerateString(fileName);
		fileName = makeUniqueName(fileName);
		return fileName;
	}
	
	private String base64URL(String base64){
		return "data:image/jpg;base64,"+base64;
	}

	private void saveImage(String name, MultipartFile file) {
		imageService.addImage(name, file);
	}

	@RequestMapping(value = UPLOAD, method = POST)
	public @ResponseBody String uploadFile(@RequestParam(FILENAME) String fileName, @RequestParam(FILE) MultipartFile file) {
		fileName = normalizeFileName(fileName);
		saveImage(fileName, file);
		return "";
	}
}
