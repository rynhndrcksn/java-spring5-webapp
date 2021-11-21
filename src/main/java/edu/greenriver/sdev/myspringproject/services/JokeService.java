package edu.greenriver.sdev.myspringproject.services;

import edu.greenriver.sdev.myspringproject.db.IJokeRepo;
import edu.greenriver.sdev.myspringproject.models.Job;
import edu.greenriver.sdev.myspringproject.models.Joke;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Joke service that provides methods for dealing with IJokeRepo
 *
 * @author Ryan H.
 * @version 1.0
 */
@Service
public class JokeService {
	private IJokeRepo jokeRepo;

	/**
	 * Default constructor to inject those dependencies
	 * @param jokeRepo IJokeRepo added using DI
	 */
	public JokeService(IJokeRepo jokeRepo) {
		this.jokeRepo = jokeRepo;
	}

	/**
	 * Saves a new joke object
	 * CREATE/PUT
	 *
	 * @param joke Joke to save
	 * @return a Joke object for the API controller
	 */
	public Joke saveJoke(Joke joke) {
			return jokeRepo.save(joke);
	}

	/**
	 * Returns every Joke in the DB
	 * READ part 1
	 *
	 * @return all Joke objects in the DB
	 */
	public List<Joke> getAllJokes() {
		return jokeRepo.findAll();
	}

	/**
	 * Returns a specific Joke in the DB
	 * READ part 2
	 *
	 * @param id ID of the joke to return
	 * @return a joke identified by id
	 */
	public Joke getJoke(int id) {
		return jokeRepo.findById(id).orElse(null);
	}

	/**
	 * Deleted a specific joke from the DB
	 *
	 * @param id ID of joke to be deleted
	 */
	public void deleteJoke(int id) {
		jokeRepo.deleteById(id);
	}

	/**
	 * Tells us if the job exists in the DB
	 *
	 * @param id ID to find Job by
	 * @return true if the job exists in the DB, otherwise false
	 */
	public boolean jokeExists(int id) {
		return getJoke(id) == null;
	}

	/**
	 * Edits the Job in the DB
	 *
	 * @param joke Job to edit
	 * @return the job to save, for the API controller
	 */
	public Joke editJoke(Joke joke) {
		if (jokeRepo.findById(joke.getJokeID()).isEmpty()) {
			throw new NoSuchElementException("Missing Joke");
		}
		return jokeRepo.save(joke);
	}

	@Override
	public String toString() {
		return "JokeService{" +
				"jokeRepo=" + jokeRepo +
				'}';
	}
}
