package com.yuraloga.ecarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableEurekaClient
@SpringBootApplication
public class EcarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcarServiceApplication.class, args);
	}
}
