package edu.greenriver.sdev.myspringproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the index page
 *
 * @author Ryan Hendrickson.
 * @version 0.5
 */
@Controller
public class IndexController {
	/**
	 * Will return index page for anyone navigating to: site.com, site.com/, site.com/index, site.com/index.html
	 *
	 * @return index.html
	 */
	@RequestMapping(value = {"", "/", "/index", "/index.html"})
	public String index() {
		// date will go here eventually

		// return the template/view for index.html
		return "index";
	}
}
