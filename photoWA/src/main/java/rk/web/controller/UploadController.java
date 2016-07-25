package rk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class UploadController {


	@RequestMapping(method = GET)
	public String home() {
		return "home";
	}


}