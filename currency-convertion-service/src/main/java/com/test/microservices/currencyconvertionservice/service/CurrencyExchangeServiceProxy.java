package com.test.microservices.currencyconvertionservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.microservices.currencyconvertionservice.bean.CurrencyConversionBean;

//name - from services application.properties file, url - 
@FeignClient(name = "currency-exchange-service")
//@FeignClient(name = "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//method like in Exchange service!
	//add name to @PathVariable! otherwise the proxy been will not be created
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
