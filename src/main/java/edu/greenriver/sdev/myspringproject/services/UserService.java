package edu.greenriver.sdev.myspringproject.services;

import edu.greenriver.sdev.myspringproject.db.IUserRepo;
import edu.greenriver.sdev.myspringproject.models.Permission;
import edu.greenriver.sdev.myspringproject.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * User service that provides methods for dealing with IUserRepo
 *
 * @author Ryan H.
 * @version 1.0
 */
@Service
public class UserService {
	private IUserRepo repo;

	/**
	 * Dependency injection for IUserRepo
	 *
	 * @param repo IUserRepo object
	 */
	public UserService(IUserRepo repo) {
		this.repo = repo;
	}

	/**
	 * Saves a User object to the database
	 * CREATE
	 *
	 * @param user User object to save
	 */
	public void saveUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setPermissions(new ArrayList<>());
		user.getPermissions().add(new Permission(0, "user", user));
		repo.save(user);
	}

	@Override
	public String toString() {
		return "UserService{" +
				"repo=" + repo +
				'}';
	}
}
