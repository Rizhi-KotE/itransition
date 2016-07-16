package photoapplication.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static photoapplication.config.Constants.FILENAME;
import static photoapplication.config.Constants.UPLOAD;
import static photoapplication.config.Constants.FILE;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import utils.TestUtils;

@Controller
public class UploadController {

	private static final int LENGTH_OF_GENERATED_STRING = 10;

	@RequestMapping(method = GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value=UPLOAD, method = POST)
	public String uploadFile(@RequestParam(FILENAME)String fileName, @RequestParam(FILE) MultipartFile file) {
		fileName = normalizeFileName(fileName);
		saveImage(fileName, file);
		return "home";
	}
	
	private String normalizeFileName(String fileName) {
		fileName = ifNullGenerateString(fileName);
		fileName = makeUniqueName(fileName);
		return fileName;
	}

	private void saveImage(String name, MultipartFile file){
		
	}
	
	private static String makeUniqueName(String fileName) {
		return fileName;
	}

	public static String ifNullGenerateString(String fileName) {
		if(fileName==null){
			fileName = TestUtils.getRandomIntegerString(LENGTH_OF_GENERATED_STRING);
		}
		return fileName;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxInMemorySize(10000);
		return resolver;
	}

}