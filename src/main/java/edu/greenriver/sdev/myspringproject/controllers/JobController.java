package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Job pages.
 *
 * @author Ryan H.
 * @version 1.0
 */
@Controller
@RequestMapping("jobs") // tells everything below to prepend jobs/ before the route
public class JobController {
	private JobService service;

	/**
	 * Default constructor
	 * @param service - JobService object
	 */
	public JobController(JobService service) {
		this.service = service;
	}

	/**
	 * Returns a summary of all jobs
	 *
	 * @param model - Model object to manipulate views
	 * @return "jobs/all"
	 */
	@RequestMapping("all")
	public String getAll(Model model) {
		model.addAttribute("jobs", service.allJobs());
		return "jobs/summary";
	}

	/**
	 * Returns a single job by ID
	 *
	 * @param model - Model object to manipulate views
	 * @param job - ID of job to return
	 * @return "jobs/one/{id}"
	 */
	@RequestMapping("one/{job}")
	public String getOne(Model model, @PathVariable int job) {
		model.addAttribute("job", service.oneJob(job));
		return "jobs/single";
	}

	/**
	 * Returns a random Job
	 *
	 * @param model - Model object to manipulate views
	 * @return a random Job object
	 */
	@RequestMapping("random")
		public String getRand(Model model) {
			model.addAttribute("job", service.random());
			return "jobs/single";
		}

	@Override
	public String toString() {
		return "JobController{" +
				"service=" + service +
				'}';
	}
}
