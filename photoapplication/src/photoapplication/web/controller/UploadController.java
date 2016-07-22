package photoapplication.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/")
public class UploadController {


	@RequestMapping(method = GET)
	public String home() {
		return "home";
	}


}