package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.models.Job;
import edu.greenriver.sdev.myspringproject.services.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTFUL controller for jobs
 *
 * @author Ryan H.
 * @version 1.0
 */
@RestController
@RequestMapping("api/jobs")
public class JobApiController {
	private JobService service;

	/**
	 * Default constructor
	 *
	 * @param service JobService for DI
	 */
	public JobApiController(JobService service) {
		this.service = service;
	}

	/**
	 * GET method for all jobs
	 *
	 * @return a List of all Jobs
	 */
	@GetMapping
	public ResponseEntity<List<Job>> allProducts() {
		return new ResponseEntity<>(service.allJobs(), HttpStatus.OK);
	}

	/**
	 * GET method for a single job
	 *
	 * @param id id of Job to return
	 * @return a ResponseEntity
	 */
	@GetMapping("{id}") //http://localhost:8080/api/jobs/{id}
	public ResponseEntity<Job> jobById(@PathVariable int id) {
		if (service.jobExists(id)) { // job isn't there
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.oneJob(id), HttpStatus.OK);
	}

	/**
	 * POST a new job
	 *
	 * @param job Job to POST
	 * @return a ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<Job> addProduct(@RequestBody Job job) {
		return new ResponseEntity<>(service.saveJob(job), HttpStatus.CREATED);
	}

	/**
	 * PUTS a Job in the DB
	 *
	 * @param job Job to PUT
	 * @return a ResponseEntity
	 */
	@PutMapping
	public ResponseEntity<Job> editProduct(@RequestBody Job job) {
		if (service.jobExists(job.getJobID())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.editJob(job), HttpStatus.NO_CONTENT);
	}

	/**
	 * DELETE a Job
	 *
	 * @param id ID of Job to delete
	 * @return a ResponseEntity
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
		service.deleteJob(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public String toString() {
		return "JobApiController{" +
				"service=" + service +
				'}';
	}
}
