package edu.greenriver.sdev.myspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Grants authorization to User objects
 *
 * @author Ryan H.
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;

	private String role;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Override
	public String getAuthority() {
		return role;
	}
}
