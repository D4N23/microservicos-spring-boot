package com.registerserve.registerserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterServeApplication.class, args);
	}

}
