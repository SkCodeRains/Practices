package com.in28minutes.springboot.learnjpaandhibernate.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJPARepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(10, "Spring boot", "Rains"));
		courseJdbcRepository.insert(new Course(20, "Spring Security", "Rains"));
		courseJdbcRepository.insert(new Course(30, "Spring Cloud", "Rains"));
		courseJdbcRepository.deleteById(10);
		System.out.println(courseJdbcRepository.findByid(20));
	}

}
