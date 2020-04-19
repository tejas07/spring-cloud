package com.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Microserviceclient1Controller {
	@Value("${microserviceclient1.isWorking}")
	private String clientFrom;
	
	@Value("${instance}")
	private String instanceNo;
	
	@GetMapping("/client1")
	public String client1() {
		return clientFrom+" & instance number "+instanceNo;
	}
}
