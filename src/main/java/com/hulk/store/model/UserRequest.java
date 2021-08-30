package com.hulk.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * Gets the password.
 *
 * @return the password
 */
@Getter

/**
 * Sets the password.
 *
 * @param password the new password
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new user request.
 *
 * @param username the username
 * @param password the password
 */
@AllArgsConstructor

/**
 * Instantiates a new user request.
 */
@NoArgsConstructor
public class UserRequest {

	/** The username. */
	private String username;
	
	/** The password. */
	private String password;

}
