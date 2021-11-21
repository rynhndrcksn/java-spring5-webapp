package edu.greenriver.sdev.myspringproject.db;

import edu.greenriver.sdev.myspringproject.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Joke interface that handles dealing with JPA
 *
 * @author Ryan H.
 * @version 1.0
 */
@Repository
public interface IJokeRepo extends JpaRepository<Joke, Integer> {
}
