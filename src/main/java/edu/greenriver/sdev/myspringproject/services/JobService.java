package edu.greenriver.sdev.myspringproject.services;

import edu.greenriver.sdev.myspringproject.models.Job;
import org.springframework.stereotype.Service;

import edu.greenriver.sdev.myspringproject.db.IJobRepo;

import java.util.List;
import java.util.Random;

/**
 * Job service that provides methods for dealing with IJobRepo
 *
 * @author Ryan H.
 * @version 1.0
 */
@Service
public class JobService {
	private IJobRepo jobRepo;

	/**
	 * Default constructor
	 *
	 * @param jobRepo - IJobRepo object
	 */
	public JobService(IJobRepo jobRepo) {
		this.jobRepo = jobRepo;
	}

	/**
	 * saves a job object to the database
	 * CREATE/UPDATE
	 * @param job a job object to save
	 */
	public void saveJob(Job job) {
		jobRepo.save(job);
	}

	/**
	 * Returns all jobs
	 * READ
	 * @return a List of all Jobs
	 */
	public List<Job> allJobs() {
		return jobRepo.findAll();
	}

	/**
	 * Returns a single job by ID
	 * READ
	 * @param id ID of job to return
	 * @return a Job object
	 */
	public Job oneJob(int id) {
		return jobRepo.findById(id).orElse(null);
	}

	/**
	 * Returns a random job
	 * READ
	 * @return a random Job
	 */
	public Job random() {
		Random rand = new Random();
		return jobRepo.findAll().get(rand.nextInt(jobRepo.findAll().size()));
	}

	@Override
	public String toString() {
		return "JobService{" +
				"jobRepo=" + jobRepo +
				'}';
	}
}
