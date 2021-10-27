package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.models.Job;
import edu.greenriver.sdev.myspringproject.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller for form pages
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
@RequestMapping("jobs") // tells everything below to prepend jobs/ before the route
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

	/**
	 * loads an empty form with a Job object mapped to it
	 *
	 * @param model Model object to load things to form
	 * @return forms/form
	 */
	@GetMapping("form")
	public String loadForm(Model model) {
		model.addAttribute("job", new Job());
		return "forms/form";
	}

	/**
	 * loads a form to edit a Job object
	 *
	 * @param job Job object to edit
	 * @return redirect:/jobs/all
	 */
	@PostMapping("form")
	public String editForm(@ModelAttribute Job job) {
		service.saveJob(job);
		return "redirect:/jobs/all";
	}

	@Override
	public String toString() {
		return "FormController{" +
				"service=" + service +
				'}';
	}
}
