package com.test.micriservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sampleApi")
	@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse") // if default - 3 times
	public String sampleApi() {
		logger.info("Method was invoked");
		ResponseEntity<String> forEntity = new RestTemplate()
				.getForEntity("localhost:8080/testing", String.class);		
		return forEntity.getBody();
	}
	
	@GetMapping("/cb")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	public String circuitBreaker() {
		logger.info("Method was invoked");
		ResponseEntity<String> forEntity = new RestTemplate()
				.getForEntity("localhost:8080/testing", String.class);		
		return forEntity.getBody();
	}
	
	private String hardcodedResponse(Exception e) {
		return "fallback response";
	}
}
