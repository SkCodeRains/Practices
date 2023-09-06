package com.in28minutes.springboot.learnjpaandhibernate.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLIneRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpa courseJdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.save(new CourseSpringJpa(11, "Spring boot", "Rains"));
		courseJdbcRepository.save(new CourseSpringJpa(21, "Spring Security", "Rains"));
		courseJdbcRepository.save(new CourseSpringJpa(31, "Spring Cloud", "Rains"));
		courseJdbcRepository.deleteById(11l);
		System.out.println(courseJdbcRepository.findById(21l));
		System.out.println(courseJdbcRepository.findByAuthor("Rains"));
		System.out.println(courseJdbcRepository.count());
	}

}
