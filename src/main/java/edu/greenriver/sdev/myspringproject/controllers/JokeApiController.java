package edu.greenriver.sdev.myspringproject.controllers;

import edu.greenriver.sdev.myspringproject.models.Joke;
import edu.greenriver.sdev.myspringproject.services.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTFUL controller for jokes
 *
 * @author Ryan H.
 * @version 1.0
 */
@RestController
@RequestMapping("api/jokes")
public class JokeApiController {
	private JokeService service;

	/**
	 * Default constructor
	 *
	 * @param service JokeService for DI
	 */
	public JokeApiController(JokeService service) {
		this.service = service;
	}

	/**
	 * GET method for all jokes
	 *
	 * @return a List of all Jokes
	 */
	@GetMapping
	public ResponseEntity<List<Joke>> allProducts() {
		return new ResponseEntity<>(service.getAllJokes(), HttpStatus.OK);
	}

	/**
	 * GET method for a single joke
	 *
	 * @param id id of Joke to return
	 * @return a ResponseEntity
	 */
	@GetMapping("{id}") //http://localhost:8080/api/jokes/{id}
	public ResponseEntity<Joke> jokeById(@PathVariable int id) {
		if (service.jokeExists(id)) { // joke isn't there
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.getJoke(id), HttpStatus.OK);
	}

	/**
	 * POST a new joke
	 *
	 * @param joke Joke to POST
	 * @return a ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<Joke> addProduct(@RequestBody Joke joke) {
		return new ResponseEntity<>(service.saveJoke(joke), HttpStatus.CREATED);
	}

	/**
	 * PUTS a Joke in the DB
	 *
	 * @param joke Joke to PUT
	 * @return a ResponseEntity
	 */
	@PutMapping
	public ResponseEntity<Joke> editProduct(@RequestBody Joke joke) {
		if (service.jokeExists(joke.getJokeID())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(service.editJoke(joke), HttpStatus.NO_CONTENT);
	}

	/**
	 * DELETE a Joke
	 *
	 * @param id ID of Joke to delete
	 * @return a ResponseEntity
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
		service.deleteJoke(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public String toString() {
		return "JokeApiController{" +
				"service=" + service +
				'}';
	}
}
