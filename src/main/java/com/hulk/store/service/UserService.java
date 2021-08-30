package com.hulk.store.service;

import com.hulk.store.model.UserRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Creates the user.
	 *
	 * @param userRequest the user request
	 * @return the string
	 */
	public abstract String createUser(UserRequest userRequest);

}
