package com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Services.RoleService;
import com.entities.Roles;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("/add-role")
	public String addRolePage(Model m) {
		m.addAttribute("role", new Roles());
		return "AddOrUpdateRole";
	}

	@RequestMapping(value = {"/add-role","/update-role"}, method = RequestMethod.POST)
	public String addRole(@ModelAttribute Roles role, Model m) {
		Roles saveRole = roleService.saveRole(role);
		m.addAttribute("role", saveRole);
		m.addAttribute("isUpdating", true);
		return "AddOrUpdateRole";
	}

}
