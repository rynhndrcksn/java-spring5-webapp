package edu.greenriver.sdev.myspringproject.db;

import edu.greenriver.sdev.myspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User interface for dealing with JPA
 *
 * @author Ryan H.
 * @version 1.0
 */
public interface IUserRepo extends JpaRepository<User, Integer> {

	/**
	 * Finds a User object by username
	 *
	 * @param username username to search DB for
	 * @return User object if found, otherwise null
	 */
	User findByUsername(String username);

}
