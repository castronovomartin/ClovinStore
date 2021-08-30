package com.hulk.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "users")

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
 * Instantiates a new user.
 *
 * @param idUser the id user
 * @param username the username
 * @param password the password
 */
@AllArgsConstructor

/**
 * Instantiates a new user.
 */
@NoArgsConstructor
public class User {

	/** The id user. */
	@Id
	@Column(name = "id_user", unique = true, nullable = false)
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String idUser;
	
	/** The username. */
	@Column(name = "username", unique = true, nullable = false, length = 60)
	private String username;
	
	/** The password. */
	@Column(name = "password", nullable = false, length = 60)
	private String password;

}
