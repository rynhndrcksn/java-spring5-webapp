package edu.greenriver.sdev.myspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Class that creates Job objects
 *
 * @author Ryan H.
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // this marks the as a Hibernated Entity (table will be created to store Job objects)
public class Job implements Comparable<Job> {
	@Id // this is a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // this is auto-increment the primary key
	private int jobID;

	private String name;
	private String employer;
	private LocalDate startDate;
	private LocalDate endDate;
	private String description;

	@Override
	public int compareTo(Job o) {
		return this.startDate.compareTo(o.startDate);
	}
}
