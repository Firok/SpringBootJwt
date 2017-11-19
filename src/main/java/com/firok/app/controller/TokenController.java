package com.firok.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firok.app.model.JwtUser;
import com.firok.app.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	private final Logger log = LoggerFactory.getLogger(TokenController.class);
	private JwtGenerator jwtGenerator;

	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping
	public String generate(@RequestBody final JwtUser jwtUser) {
		log.info("jwtUser ='{}'", jwtUser);
		return jwtGenerator.generate(jwtUser);
	}

}
