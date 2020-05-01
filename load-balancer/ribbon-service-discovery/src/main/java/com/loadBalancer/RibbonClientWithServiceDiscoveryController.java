package com.loadBalancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@RestController
public class RibbonClientWithServiceDiscoveryController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	EurekaClient eurekaClient;
	public static Logger log=LoggerFactory.getLogger(RibbonClientWithServiceDiscoveryController.class);
	@GetMapping("/ribbonClient")
	public String ribbonClient(){
		log.info("ribbonClient ");
		ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://microserviceclient1/client1",String.class);
		return responseEntity.getBody();
	}

}
