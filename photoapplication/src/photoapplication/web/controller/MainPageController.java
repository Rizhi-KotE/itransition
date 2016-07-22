package photoapplication.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static photoapplication.config.Constants.USER;
import static photoapplication.config.Constants.WORKING_AREA;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/" + USER +"/")
public class MainPageController {
	
	@RequestMapping(method = GET)
	public String showMainPage(){
		return WORKING_AREA;
	}
}
