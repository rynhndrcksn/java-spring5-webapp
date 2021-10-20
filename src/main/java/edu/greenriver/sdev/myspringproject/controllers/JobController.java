package edu.greenriver.sdev.myspringproject.controllers;

import org.springframework.stereotype.Controller;
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

	/**
	 * Returns a summary of all jobs
	 *
	 * @return "jobs/summary"
	 */
	@RequestMapping("all")
	public String getAll() {
		return "jobs/summary";
	}

	/**
	 * Returns a single job by ID
	 *
	 * @param job - ID of job to return
	 * @return "jobs/single"
	 */
	@RequestMapping("one/{job}")
	public String getOne(@PathVariable int job) {
		return "jobs/single";
	}
}
