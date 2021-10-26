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
		SpringApplication.run(MySpringProjectApplication.class, args);
	}

}
