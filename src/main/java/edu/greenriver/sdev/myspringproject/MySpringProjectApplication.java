package edu.greenriver.sdev.myspringproject;

import edu.greenriver.sdev.myspringproject.db.IUserRepo;
import edu.greenriver.sdev.myspringproject.models.Permission;
import edu.greenriver.sdev.myspringproject.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

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

		loadAccounts(context);
	}

	private static void loadAccounts(ApplicationContext context) {
		// Get beans we need
		IUserRepo userRepo = context.getBean(IUserRepo.class);
		BCryptPasswordEncoder passwordEncoder = context.getBean(BCryptPasswordEncoder.class);

		// Build Admin account
		User admin = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("admin"))
				.build();

		Permission adminRole = new Permission(0, "admin", admin);
		Permission userRole = new Permission(0, "user", admin);
		admin.setPermissions(new ArrayList<>());
		admin.getPermissions().add(adminRole);
		admin.getPermissions().add(userRole);

		userRepo.save(admin);
		System.out.println("Admin account saved...");

		// Build User account
		User user = User.builder()
				.username("user")
				.password(passwordEncoder.encode("user"))
				.build();

		userRole = new Permission(0, "user", user);
		user.setPermissions(new ArrayList<>());
		user.getPermissions().add(userRole);

		userRepo.save(user);
		System.out.println("User account saved...");
	}

}
