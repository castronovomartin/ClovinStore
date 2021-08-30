package com.hulk.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulk.store.model.UserRequest;
import com.hulk.store.service.UserService;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/users")

/** The Constant log. */
@Slf4j
public class UserController {

	/** The user service. */
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	/**
	 * Creates the user.
	 *
	 * @param userRequest the user request
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
		log.info("Entra al controller del servicio createUser");
		String messageResponse = userService.createUser(userRequest);
		return new ResponseEntity<String>(messageResponse, HttpStatus.OK);
	}

}
