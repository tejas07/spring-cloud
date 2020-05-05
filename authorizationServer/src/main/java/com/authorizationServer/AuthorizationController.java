package com.authorizationServer;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController {
	public static Logger logger=LoggerFactory.getLogger(AuthorizationController.class);
	@GetMapping("/user")
	public Principal userDetails(Principal principal) {
		logger.info(principal.getName());
		logger.info(principal.getClass().getSimpleName());
		return principal;
	}
}
