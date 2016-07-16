package photoapplication.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class UploadController {

	@RequestMapping(method = GET)
	public String home() {
		return "home";

	}

}