package com.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OauthController {
	@Autowired
	private OAuth2ClientContext clientContext;
	static private Logger logger = LoggerFactory.getLogger(OauthController.class);

	@GetMapping("/oauth/home")
	public String oAuth() {
		logger.info("oAuth()");
		accessToken();
		return "home";
	}

	@GetMapping("/oauth/report")
	public String report() {
		logger.info("oAuth()");          
		return "report";
	}

	@ModelAttribute("accessToken")
	public String accessToken() {
		logger.info("accessToken");
		OAuth2AccessToken accessToken = clientContext.getAccessToken();
		logger.info("accessToken " + accessToken.getValue());
		logger.info("bearerType " + accessToken.BEARER_TYPE.toString());
		logger.info("tokenType " + accessToken.getTokenType());
		return accessToken.getValue();
	}
}
