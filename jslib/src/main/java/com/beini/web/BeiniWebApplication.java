package com.beini.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
/*方式一：步骤二*/
@EnableCircuitBreaker
public class BeiniWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeiniWebApplication.class, args);
	}
}
