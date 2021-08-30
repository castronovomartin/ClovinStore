package com.hulk.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hulk.store.converter.TestCrypt;
import com.hulk.store.entity.User;
import com.hulk.store.model.UserRequest;
import com.hulk.store.repository.UserRepository;
import com.hulk.store.service.UserService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
@Service("userServiceImpl")

/** The Constant log. */
@Slf4j
public class UserServiceImpl extends ExceptionCommonServiceImpl implements UserService {

	/** The Constant USER_CREATED. */
	public static final String USER_CREATED = "The user was created successfully.";
	
	/** The Constant USER_LOGGED. */
	public static final String USER_LOGGED = "The user has been successfully logged in.";

	/** The test crypt. */
	@Autowired
	@Qualifier("testCrypt")
	private TestCrypt testCrypt;

	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	/**
	 * Creates the user.
	 *
	 * @param userRequest the user request
	 * @return the string
	 */
	@Override
	public String createUser(UserRequest userRequest) {
		log.info("Ejecuta servicio: createUser");
		checkUserExistByUsername(userRequest.getUsername());
		userRepository.save(User.builder().username(testCrypt.encrypt(userRequest.getUsername()))
				.password(testCrypt.encrypt(userRequest.getPassword())).build());
		return USER_CREATED;
	}

}
