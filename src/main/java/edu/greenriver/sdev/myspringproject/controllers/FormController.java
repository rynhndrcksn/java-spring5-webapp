package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.models.Job;
import edu.greenriver.sdev.myspringproject.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("create")
	public String loadForm(Model model) {
		model.addAttribute("job", new Job());
		return "forms/form";
	}

	/**
	 * saves a Job object to DB
	 *
	 * @param job Job object to edit
	 * @return redirect:/jobs/all
	 */
	@PostMapping("create")
	public String handleForm(@ModelAttribute Job job) {
		service.saveJob(job);
		return "redirect:/jobs/all";
	}

	/**
	 * edits a Job in the DB located by {id}
	 *
	 * @param model model Object to load things to the view
	 * @param id id of Job in DB to edit
	 * @return forms/form
	 */
	@GetMapping("edit/{id}")
	public String editForm(Model model, @PathVariable int id) {
		model.addAttribute("job", service.oneJob(id));
		return "forms/form";
	}

	/**
	 * deletes a Job object from the DB by id
	 *
	 * @param id of Job object to delete
	 * @return redirect:jobs/all
	 */
	@GetMapping("delete/{id}")
	public String deleteJob(@PathVariable int id) {
		service.deleteJob(id);
		return "redirect:/jobs/all";
	}

	@Override
	public String toString() {
		return "FormController{" +
				"service=" + service +
				'}';
	}
}
