package com.coderains.rainsbank.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderains.rainsbank.model.Customer;
import com.coderains.rainsbank.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class LoginController {

	private CustomerRepository customerRepository;
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register.ss")
	public ResponseEntity<String> postMethodName(@RequestBody Customer customer) {
		ResponseEntity<String> responseEntity;
		try {
			Customer Oldcustomer = customerRepository.findByUsername(customer.getUsername());
			if (Oldcustomer != null) {
				responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("User already registered");
			} else {
				customer.setPwd(passwordEncoder.encode(customer.getPwd()));
				customerRepository.save(customer);
				responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("User register succefully");
			}
		} catch (DataIntegrityViolationException error) {
			responseEntity = ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY)
					.body("Dependency Failed please check mendatory field");
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("There might be server error please check once data are proper or not !");
		}

		return responseEntity;
	}

	@RequestMapping("/user.ss")
	public Customer getUserDetailsAfterLogin(Authentication authentication) {
		Customer customers = customerRepository.findByUsername(authentication.getName());
		if (customers != null) {
			return customers;
		} else {
			return null;
		}
	}
}
