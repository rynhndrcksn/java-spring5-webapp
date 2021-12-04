package edu.greenriver.sdev.myspringproject.services;

import edu.greenriver.sdev.myspringproject.db.IUserRepo;
import edu.greenriver.sdev.myspringproject.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Login Service for the User
 *
 * @author Ryan H.
 * @version 1.0
 */
@Service
public class LoginService implements UserDetailsService {

	private IUserRepo repo;

	/**
	 * Dependency injection for the repo
	 *
	 * @param repo IUserRepo to manipulate DB
	 */
	public LoginService(IUserRepo repo) {
		this.repo = repo;
	}

	/**
	 * This method gets called everytime someone tries to log in.
	 *
	 * @param username username
	 * @return matching user from DB.
	 * @throws UsernameNotFoundException when username isn't found.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);

		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("Username not found!");
		}
	}

	@Override
	public String toString() {
		return "LoginService{" +
				"repo=" + repo +
				'}';
	}
}
