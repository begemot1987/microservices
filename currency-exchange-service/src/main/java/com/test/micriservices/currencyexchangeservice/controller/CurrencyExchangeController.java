package com.test.micriservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.micriservices.currencyexchangeservice.been.ExchangeValue;
import com.test.micriservices.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	private final Environment environment;
	private final ExchangeValueRepository repository;
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	public CurrencyExchangeController(Environment environment, ExchangeValueRepository repository) {
		this.environment = environment;
		this.repository = repository;
	}

	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getValue(@PathVariable String from, @PathVariable String to) {
		logger.info("getValue method was called");
		ExchangeValue exchangeValue=  repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
