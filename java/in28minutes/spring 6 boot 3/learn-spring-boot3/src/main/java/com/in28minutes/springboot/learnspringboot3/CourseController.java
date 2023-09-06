package com.in28minutes.springboot.learnspringboot3;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CurrencyServiceConfiguration currencyServiceConfigurationR;

	@GetMapping("/courses")
	public List<Course> retriveAllCourses() {
		return Arrays.asList(new Course(1, "Learn AWS", "in 28 minutes"),
				new Course(1, "Learn DevOps", "in 28 minutes"), new Course(1, "Learn React", "in 28 minutes"),
				new Course(1, "Learn SpringBoot", "in 28 minutes"));
	}

	@GetMapping("/currency-configuration")
	public CurrencyServiceConfiguration getCurrency() {
		return currencyServiceConfigurationR;

	}

}


record Course(int id, String name, String author) {
}