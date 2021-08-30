package com.hulk.store.config;

import java.time.Duration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class WebSecurityConfig.
 */
@EnableWebSecurity

/** The Constant log. */
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("configura los endpoints autorizados");
		http.authorizeRequests()
				.antMatchers("/users/**", "/products/**", "/categories/**", "/cards/**", "/brands/**", "/categories/**")
				.permitAll();
		http.csrf().ignoringAntMatchers("/users/**", "/products/**", "/categories/**", "/cards/**", "/brands/**",
				"/categories/**");
		http.headers().frameOptions().sameOrigin().xssProtection().disable();
		http.headers().httpStrictTransportSecurity().maxAgeInSeconds(Duration.ofDays(365).getSeconds());
		http.headers().cacheControl().disable();
	}

}
