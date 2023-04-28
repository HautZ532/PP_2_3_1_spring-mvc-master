package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		UserDaoImp userDaoImp = new UserDaoImp();
		User user1 = new User();
		user1.setName("Bob");
		user1.setLastName("Jones");
		user1.setEmail("bob@mail.ru");
		userDaoImp.saveUser(user1);
//		User user2 = new User();
//		user2.setName("Make");
//		user2.setLastName("Sheron");
//		user2.setEmail("make@mail.ru");
//		userDaoImp.saveUser(user2);
//		System.out.println(userDaoImp.getAllUsers());
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

}