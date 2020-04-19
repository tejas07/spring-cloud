package com.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CentralisedConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CentralisedConfigServerApplication.class, args);
	}

}
