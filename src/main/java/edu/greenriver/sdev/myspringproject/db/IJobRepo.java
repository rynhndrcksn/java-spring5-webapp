package edu.greenriver.sdev.myspringproject.db;

import edu.greenriver.sdev.myspringproject.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Job interface that handles dealing with JPA
 *
 * @author Ryan H.
 * @version 1.0
 */
@Repository
public interface IJobRepo extends JpaRepository<Job, Integer> {
}
