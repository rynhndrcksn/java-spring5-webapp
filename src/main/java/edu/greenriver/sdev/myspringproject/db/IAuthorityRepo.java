package edu.greenriver.sdev.myspringproject.db;

import edu.greenriver.sdev.myspringproject.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for dealing with JPA
 *
 * @author Ryan H.
 * @version 1.0
 */
public interface IAuthorityRepo extends JpaRepository<Authority, Integer> {

}
