package com.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Services.UserService;
import com.entities.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/add-user")
	public String addUserPage(Model m) {
		System.out.println("Add User page");
		m.addAttribute("user", new User());
		return "AddUser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user, Model m) {

		boolean isSaved = userService.addUser(user);
		System.out.println("Add User page");

		m.addAttribute("msg", isSaved ? "User added" : "Filed to add User");
		m.addAttribute("isSaved", isSaved);

		return "AddUser";
	}

	@RequestMapping("/get-all-users")
	public String getAllUsers(Model m) {

		List<User> users = userService.getAllUsers();

		m.addAttribute("users", users);
		return "AllUsers";
	}

	@RequestMapping("/delete-user")
	public String deleteUsers(@RequestParam Integer userId) {

		Boolean isDeleted = userService.deleteUsers(userId);

		return "redirect:/get-all-users";
	}

	@RequestMapping("/update-user")
	public String updateUsersPage(@RequestParam Integer userId, Model m) {

		User user = userService.updateUsers(userId);
		m.addAttribute("user", user);
		m.addAttribute("isUpdating", true);
		return "AddUser";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateUsers(@ModelAttribute User user, Model m) {
		System.out.println("Updating user " + user);
		userService.updateUser(user);

		return "redirect:/get-all-users";
	}

}
