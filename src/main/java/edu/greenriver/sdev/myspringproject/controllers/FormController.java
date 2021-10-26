package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller for form pages
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
public class FormController {
	// use this to manipulate the database
	private JobService service;

	/**
	 * default constructor
	 *
	 * @param service JobService dependency injection
	 */
	public FormController(JobService service) {
		this.service = service;
	}

	@RequestMapping("jobs/form")
	public String form() {
		return "forms/form";
	}

	@Override
	public String toString() {
		return "FormController{" +
				"service=" + service +
				'}';
	}
}
