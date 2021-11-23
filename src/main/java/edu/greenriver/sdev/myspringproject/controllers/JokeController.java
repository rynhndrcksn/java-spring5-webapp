package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Joke pages.
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
@RequestMapping("jokes") // tells everything below to prepend jokes/ before the route
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
	 * @return "jokes/all"
	 */
	@RequestMapping(value = {"", "{id}"}) // http://localhost:8080/jokes OR http://localhost:8080/jokes/{id}
	public String getJokes() {
		return "jokes/index";
	}

	@Override
	public String toString() {
		return "JobController{" +
				"service=" + service +
				'}';
	}
}
