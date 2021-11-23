package edu.greenriver.sdev.myspringproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the admin page
 *
 * @author Ryan Hendrickson.
 * @version 1.0
 */
@Controller
public class AdminController {

	/**
	 * Returns the admin page at localhost:8080/admin
	 *
	 * @return "admin"
	 */
	@RequestMapping("admin")
	public String admin() {
		return "admin";
	}
}
