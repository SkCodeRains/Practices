package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class currencyConfigurationController {

	@Autowired
	currencyServiceConfiguration currencyService;

	@GetMapping("/currency-service")
	public currencyServiceConfiguration getCurrency() {
		return currencyService;
	}
}
