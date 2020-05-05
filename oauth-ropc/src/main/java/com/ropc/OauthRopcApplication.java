package com.ropc;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class OauthRopcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OauthRopcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResourceOwnerPasswordResourceDetails resourceDetails=new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:8011/authorizationServer/oauth/token");
		resourceDetails.setClientId("oauthClient");
		resourceDetails.setClientSecret("oauthClient");
//		resourceDetails.setGrantType("password");
		resourceDetails.setUsername("user1");
		resourceDetails.setPassword("password1");
		resourceDetails.setScope(Arrays.asList("/oauth-client/person"));
		OAuth2RestTemplate restTemplate=new OAuth2RestTemplate(resourceDetails);
		System.out.println("token "+restTemplate.getAccessToken());
		ResponseEntity<String> s=restTemplate.getForEntity("http://localhost:8010/oauth-client/person",String.class);
		System.out.println("String "+s.getBody());
	}
}
