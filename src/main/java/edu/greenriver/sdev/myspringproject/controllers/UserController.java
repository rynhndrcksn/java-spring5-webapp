package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.models.User;
import edu.greenriver.sdev.myspringproject.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller for user registration
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
@RequestMapping // localhost:8080/.../...
public class UserController {
	private UserService service;

	/**
	 * Dependency injection for UserService
	 *
	 * @param service UserService
	 */
	public UserController(UserService service) {
		this.service = service;
	}

	/**
	 * loads an empty form with a Job object mapped to it
	 *
	 * @param model Model object to load things to form
	 * @return users/register.html
	 */
	@GetMapping("users/register")
	public String loadForm(Model model) {
		model.addAttribute("user", new User());
		return "users/register";
	}

	/**
	 * saves a User object to DB
	 *
	 * @param user User object to save
	 * @return redirect:/index
	 */
	@PostMapping("users/register")
	public String handleForm(@ModelAttribute User user) {
		service.saveUser(user);
		return "redirect:/index";
	}

	/**
	 * Logs the user into the website
	 *
	 * @param model Model object for model binding
	 * @return users/login.html
	 */
	@GetMapping("login")
	public String loadLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@Override
	public String toString() {
		return "UserController{" +
				"service=" + service +
				'}';
	}
}
