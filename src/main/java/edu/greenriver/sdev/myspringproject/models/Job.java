package edu.greenriver.sdev.myspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

	private String position;
	private String employer;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;
	private String description;

	@Override
	public int compareTo(Job other) {
		return this.startDate.compareTo(other.startDate);
	}
}
