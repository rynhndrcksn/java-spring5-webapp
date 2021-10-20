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
	 * Returns all jobs
	 *
	 * @return a List of all Jobs
	 */
	public List<Job> allJobs() {
		return jobRepo.findAll();
	}

	/**
	 * Returns a single job by ID
	 *
	 * @param id - ID of job to return
	 * @return a Job object
	 */
	public Job oneJob(int id) {
		return jobRepo.findById(id).orElse(null);
	}

	/**
	 * Returns a random job
	 *
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
