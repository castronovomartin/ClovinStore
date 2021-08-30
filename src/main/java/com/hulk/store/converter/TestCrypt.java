package com.hulk.store.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCrypt.
 */
@Component("testCrypt")

/** The Constant log. */
@Slf4j
public class TestCrypt {

	/**
	 * Encrypt.
	 *
	 * @param code the code
	 * @return the string
	 */
	public String encrypt(String code) {
		log.info("Procede a codificar algo que debe cifrarse");
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(code);
	}

}
