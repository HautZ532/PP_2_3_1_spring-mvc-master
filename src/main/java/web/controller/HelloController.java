package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDaoImp;
import web.service.UserServiceImp;

@Controller
public class HelloController {
	private final UserServiceImp userServiceImp;

	public HelloController(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("usersList", userServiceImp.getAllUsers());
		return "index";
	}

}