package sample.controller;

import java.util.Map;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sample.service.UserService;

@Controller
public class UserController {

	private static final String EDIT = "0";
	private static final String SHOW = "1";
	private static final String NEW = "2";

	@Autowired
	UserService userService;

	@ModelAttribute("userModel")
	public UserModel initUserModel() {
		return new UserModel();
	}

	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String usersShow(Model model) {
		model.addAttribute("userList",userService.findAll());
		return "users";
	}

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String userShow(@RequestParam("username")String username, Model model) {
		UserModel userModel = createUserModel(username);
		model.addAttribute("userModel",userModel);
		model.addAttribute("status", SHOW);
		return "user";
	}

	@RequestMapping(value="/user/edit", method=RequestMethod.GET)
	public String userEdit(@RequestParam("username")String username, Model model) {
		UserModel userModel = createUserModel(username);
		model.addAttribute("userModel",userModel);
		model.addAttribute("status", EDIT);
		return "user";
	}

	@RequestMapping(value="/user/new", method=RequestMethod.GET)
	public String userNew(Model model) {
		model.addAttribute("userModel",new UserModel());
		model.addAttribute("status", NEW);
		return "user";
	}

	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("userModel") UserModel userModel,BindingResult bindingResult , Model model) {
		if(bindingResult.hasErrors()){
			model.addAttribute("userModel", userModel);
			model.addAttribute("status", NEW);
			return "user";
		}
		userService.createUser(userModel);
		model.addAttribute("userModel",userModel);
		model.addAttribute("status", EDIT);
		return "user";
	}

	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("userModel") UserModel userModel, Model model) {
		userService.updateUser(userModel);
		model.addAttribute("userModel",userModel);
		model.addAttribute("status", EDIT);
		return "user";
	}

	@RequestMapping(value="/user/update", method=RequestMethod.POST, params = "delete")
	public String delete(@ModelAttribute("userModel") UserModel userModel, Model model) {
		userService.deleteUser(userModel);
		model.addAttribute("userList",userService.findAll());
		return "users";
	}

	private UserModel createUserModel(String username) {
		UserModel userModel = new UserModel();
		Map findByUsername = userService.findByUsername(username);
		userModel.setUsername((String) findByUsername.get("username"));
		userModel.setMailaddress((String) findByUsername.get("mailaddress"));
		return userModel;
	}

	public class UserModel {
		@NotEmpty
		private String username;
		private String mailaddress;

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getMailaddress() {
			return mailaddress;
		}
		public void setMailaddress(String mailaddress) {
			this.mailaddress = mailaddress;
		}
	}
}