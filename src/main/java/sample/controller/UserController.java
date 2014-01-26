package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sample.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String users(Model model) {
		model.addAttribute("userList",userService.findAll());
		return "users";
	}

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String user(@RequestParam("username")String username, Model model) {
		model.addAttribute("user",userService.findByUsername(username));
		return "user";
	}
}