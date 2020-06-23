package com.marlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.marlabs.model.User;
import com.marlabs.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String showUser() {
		return "UserRegistration";

	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model model) {
		Integer userId = userService.saveuser(user);
		String message = "User :- " + userId + "save";
		model.addAttribute("message", message);
		return "UserRegister";
	}

	@GetMapping("/home")
	public String showHome() {
		return "HomePage";
	}

	@GetMapping("/admin")
	public String showInbox() {
		return "AdminPage";
	}

	@GetMapping("/manager")
	public String showEmp() {
		return "ManagerPage";
	}

	@GetMapping("/common")
	public String showCommon() {
		return "CommonPage";
	}

	@GetMapping("/denied")
	public String showNoAccess() {
		return "DeniedPage";
	}

	@GetMapping("/visitor")
	public String showVisit() {
		return "VisitorPage";
	}

}
