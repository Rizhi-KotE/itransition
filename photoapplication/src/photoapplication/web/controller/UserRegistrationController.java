package photoapplication.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import photoapplication.database.entity.ImageUser;
import photoapplication.database.service.EmailExistsException;
import photoapplication.database.service.ImageUserService;
import photoapplication.web.dto.UserDTO;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private ImageUserService service;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDTO userDto = new UserDTO();
		model.addAttribute("user", userDto);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO accountDto, BindingResult result,
			WebRequest request, Errors errors) {
		ImageUser registered = new ImageUser();
		if (!result.hasErrors()) {
			registered = createUserAccount(accountDto, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}

		if (result.hasErrors()) {
			return new ModelAndView("registration", "user", accountDto);
		} else {
			return new ModelAndView("successRegister", "user", accountDto);
		}
	}


	private ImageUser createUserAccount(UserDTO accountDto, BindingResult result) {
		ImageUser registered = null;
		try {
			registered = service.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
	}
}
