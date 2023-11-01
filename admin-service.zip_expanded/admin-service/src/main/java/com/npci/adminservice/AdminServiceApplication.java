package com.npci.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

	// write annhywhere just it mjust be visible  to springboot
	// to get service from one microservice to another
	// here this app is admin and other one is service
	@Bean               // import from org.springframework.context.annotation
	@LoadBalanced      // import from org.springframework.cloud.client.loadbalancer
	// import from  org.springframework.web.client.RestTemplate
	public RestTemplate createTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
	
}
