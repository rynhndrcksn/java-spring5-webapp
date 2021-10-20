package edu.greenriver.sdev.myspringproject;

import edu.greenriver.sdev.myspringproject.db.IJobRepo;
import edu.greenriver.sdev.myspringproject.models.Job;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Starting point for Spring application
 *
 * @author Ryan H. (technically Spring?)
 * @version 1.0
 */
@SpringBootApplication
public class MySpringProjectApplication {

	/**
	 * Entry point for the Spring app.
	 *
	 * @param args - not used.
	 */
	public static void main(String[] args) {
		// get spring container
		ApplicationContext context = SpringApplication.run(MySpringProjectApplication.class, args);

		// get the data layer bean
		IJobRepo jobRepo = context.getBean(IJobRepo.class);

		// add some jobs
		Job[] jobs = {
				Job.builder().name("Job 1")
						.startDate(LocalDate.now())
						.endDate(null)
						.description("Desc 1")
						.build(),
				Job.builder().name("Job 2")
						.startDate(LocalDate.of(2020, 8, 20))
						.endDate(LocalDate.of(2020, 9, 1))
						.description("Desc 2")
						.build(),
				Job.builder().name("Job 3")
						.startDate(LocalDate.of(2019, 3, 15))
						.endDate(LocalDate.of(2020, 8, 2))
						.description("Desc 3")
						.build(),
				Job.builder().name("Job 4")
						.startDate(LocalDate.of(2019, 1, 1))
						.endDate(LocalDate.of(2019, 3, 10))
						.description("Desc 4")
						.build()
		};

		// save all the jobs to our DB
		jobRepo.saveAll(Arrays.asList(jobs));
		System.out.println("All jobs saved to the DB");
	}

}
