package com.npci.servicediscoverydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // enables this program as service discovery
public class ServiceDiscoveryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryDemoApplication.class, args);
	}

}
