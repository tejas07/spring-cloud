package com.client2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Microserviceclient2Controller {
	@Value("${microserviceclient2.isWorking}")
	private String clientFrom;
	
	@Value("${instance}")
	private String instanceNo;
	
	@GetMapping("/client2")
	public String client2() {
		return clientFrom+" & from instance "+instanceNo ;	
	}
}
