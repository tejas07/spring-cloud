package com.oauthClient;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthClientController {
	private static Logger logger=LoggerFactory.getLogger(OAuthClientController.class);
	
	@GetMapping("/oauth-client/person")
	public List<Person> personData() {
		logger.info("personDate()");
		Person person=new Person();
		person.setAge(1);
		person.setName("Test1");
		person.setPhoneNumber("1");
		Person person1=new Person();
		person1.setAge(2);
		person1.setName("Test2");
		person1.setPhoneNumber("2");
		Person person2=new Person();
		person2.setAge(3);
		person2.setName("Test3");
		person2.setPhoneNumber("3");
		return Arrays.asList(person,person1,person2);
	} 
}
