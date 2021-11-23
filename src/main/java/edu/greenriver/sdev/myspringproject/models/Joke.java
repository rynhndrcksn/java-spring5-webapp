package edu.greenriver.sdev.myspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class that creates Joke objects
 *
 * @author Ryan H.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // this marks the as a Hibernated Entity (table will be created to store Joke objects)
public class Joke {
	@Id // this is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this is auto-increment the primary key
	private int jokeID;

	private String setup;
	private String joke;

}
