package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Joke pages.
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
@RequestMapping("jokes") // tells everything below to prepend jobs/ before the route
public class JokeController {
	private JokeService service;

	/**
	 * Default constructor
	 *
	 * @param service JokeService object
	 */
	public JokeController(JokeService service) {
		this.service = service;
	}

	/**
	 * Returns a summary of all Jokes
	 *
	 * @param model Model object to manipulate views
	 * @return "jokes/all"
	 */
	@RequestMapping("all")
	public String getAll(Model model) {
		model.addAttribute("jokes", service.getAllJokes());
		return "jokes/summary";
	}

	/**
	 * Returns a single Joke by ID
	 *
	 * @param model - Model object to manipulate views
	 * @param id - ID of joke to return
	 * @return "jokes/{id}"
	 */
	@RequestMapping("{id}")
	public String getOne(Model model, @PathVariable int id) {
		model.addAttribute("job", service.getJoke(id));
		return "jokes/single";
	}

	@Override
	public String toString() {
		return "JobController{" +
				"service=" + service +
				'}';
	}
}
