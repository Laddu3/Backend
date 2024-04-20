package com.gl.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
///It is an Eureka server
public class TravellsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravellsServerApplication.class, args);
		
		System.out.println("here is capstone project");
	}

}


