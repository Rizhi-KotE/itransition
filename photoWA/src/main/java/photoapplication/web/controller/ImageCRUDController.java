package photoapplication.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import photoapplication.database.entity.Image;
import photoapplication.database.service.ImageService;
import utils.TestUtils;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static photoapplication.config.Constants.*;

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
	private ImageService imageService;

	@RequestMapping(method = GET)
	public  List<Image> getImages(){
		return imageService.getAll();
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

	private void saveImage(String name, MultipartFile file) throws IOException {
		Image image = createImage(name);
		imageService.addImage(image, file.getBytes());
	}

	private Image createImage(String name) {
		Image image = new Image();
		image.setName(name);
		return image;
	}

	@RequestMapping(value = UPLOAD_URL, method = POST)
	public @ResponseBody String uploadFile(@RequestParam(FILENAME) String fileName, @RequestParam(FILE) MultipartFile file) throws IOException {
		fileName = normalizeFileName(fileName);
		saveImage(fileName, file);
		return "";
	}
}
