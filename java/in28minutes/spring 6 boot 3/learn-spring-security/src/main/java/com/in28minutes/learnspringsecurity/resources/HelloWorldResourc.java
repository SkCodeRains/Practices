package com.in28minutes.learnspringsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResourc {

	public HelloWorldResourc() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("hello")
	public String getMessage() {
		return "Hello world";
	}

}
