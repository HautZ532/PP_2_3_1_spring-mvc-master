package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/users")
public class UsersController {
	private final UserServiceImp userServiceImp;

	public UsersController(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}


	@GetMapping
	public String printAllUsers(Model model) {
		model.addAttribute("usersList", userServiceImp.getAllUsers());
		return "users";
	}

	@GetMapping(value = "/addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "saveUser";
	}

	@PostMapping()
	public String saveUser(@ModelAttribute("user") User user) {
		userServiceImp.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping(value = "/{id}/editUser")
	public String userEdit(@PathVariable("id") long id, Model model) {
		model.addAttribute("user", userServiceImp.getUser(id));
		return "userEdit";
	}

	@PatchMapping("/{id}")
	public String userUpdate(@ModelAttribute("user") User user) {
		userServiceImp.editUser(user);
		return "redirect:/users";
	}

	@DeleteMapping(value = "/{id}/deleteUser")
	public String removeUser(@PathVariable("id") long id) {
		userServiceImp.removeUser(id);
		return "redirect:/users";
	}

}