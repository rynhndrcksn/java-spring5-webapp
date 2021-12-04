package edu.greenriver.sdev.myspringproject.config;

import edu.greenriver.sdev.myspringproject.services.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration for Spring Security
 *
 * @author Ryan H.
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private LoginService service;

	/**
	 * Dependency injection...
	 *
	 * @param service LoginService dependency
	 */
	public SecurityConfig(LoginService service) {
		this.service = service;
	}

	/**
	 * Returns a BCrypt encoder for us to use with our in memory passwords below.
	 *
	 * @return new BCryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Configure the mechanism for authentication in this method.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Authenticate with our own DB records
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());

	}

	// Configure which files and folder are publicly available in the webapp.
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Ignore the h2-console, so it isn't blocked; ** says to ignore anything (recursively) under h2-console/
		web
				.ignoring().antMatchers("/h2-console/**");
	}

	// Configure permissions (authorization) and login/logout routines.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				// Handle what roles can access what parts of the site
				.authorizeRequests()
					.antMatchers("/admin/**").hasAuthority("admin")
					.antMatchers("/jobs/**").hasAuthority("admin")
					.antMatchers("/jokes/**").hasAnyAuthority("user")
					.antMatchers("/**").permitAll()
				.and()
					.formLogin()
						.failureForwardUrl("/login") // Custom login :D
						.permitAll()
						.loginPage("/login")
						.defaultSuccessUrl("/")
						.failureUrl("/login?error=true")
				.and()
					.logout()
					.permitAll()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout=true")
				.and()
					.csrf()
						.disable();
	}

	@Override
	public String toString() {
		return "SecurityConfig{" +
				"service=" + service +
				'}';
	}
}
