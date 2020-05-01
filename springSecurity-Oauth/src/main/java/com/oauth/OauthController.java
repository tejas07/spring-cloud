package com.oauth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OauthController {
	static private Logger logger = LoggerFactory.getLogger(OauthController.class);

	@Autowired
	private OAuth2ClientContext clientContext;
	@Autowired
	private OAuth2RestTemplate restTemplate;

	@GetMapping("/oauth/inSecure")
	public String pageWithNoSecurity() {
		logger.info("pageWithNoSecurity()");
		return "page";
	}

	@GetMapping("/oauth/home")
	public String oAuth() {
		logger.info("oAuth()");
		accessToken();
		return "home";
	}

	@GetMapping("/oauth/report")
	public String report(Model model) {
		logger.info("report()");
//		accessToken();
		List<Person> responseEntity = restTemplate.exchange("http://localhost:8010/oauth-client/person",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
				}).getBody().stream().collect(Collectors.toCollection(ArrayList::new));
//		person(responseEntity.getBody());
		model.addAttribute("persons", responseEntity);
		logger.info("person list "+responseEntity.size());
		return "report";
	}

	@ModelAttribute("accessToken")
	public String accessToken() {
		OAuth2AccessToken accessToken = null;
		try {
			logger.info("accessToken");
			accessToken = clientContext.getAccessToken();
			logger.info("accessToken " + accessToken.getValue());
			logger.info("bearerType " + accessToken.BEARER_TYPE.toString());
			logger.info("tokenType " + accessToken.getTokenType());
		} catch (NullPointerException e) {
			logger.info("Null Access token");
			return "";
		}
		return accessToken.getValue();
	}
}
