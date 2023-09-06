package com.in28minutes.springboot.learnjpaandhibernate.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Spring boot", "Rains"));
		courseJdbcRepository.insert(new Course(2, "Spring Security", "Rains"));
		courseJdbcRepository.insert(new Course(3, "Spring Cloud", "Rains"));
		courseJdbcRepository.deleteById(1);
		System.out.println(courseJdbcRepository.findByid(2));
	}

}
