package com.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClient2Application.class, args);
	}

}
