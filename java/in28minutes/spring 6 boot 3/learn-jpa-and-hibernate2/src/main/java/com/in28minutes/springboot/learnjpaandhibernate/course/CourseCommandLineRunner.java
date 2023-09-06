package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.SpringDataJpa;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//
//	@Autowired
//	private CourseJdbcRepository repository;
//	private CourseJpaRepository repository;

	@Autowired
	private SpringDataJpa repository;

	@Override
	public void run(String... args) throws Exception {
//		repository.insert(new Course(1, "learn AWS Now!", "in28minutes"));
//		repository.insert(new Course(2, "learn AWS Now!", "in28minutes"));
//		repository.insert(new Course(3, "learn AWS Now!", "in28minutes"));
//		repository.delete(2);
//		System.out.println(repository.getCourseById(1));
//		System.out.println(repository.getCourseById(3));

		repository.save(new Course(1, "learn AWS Now!", "in28minute1ss"));
		repository.save(new Course(2, "learn AWS Spring Jpa!", "in28minute1s"));
		repository.save(new Course(3, "learn AWS Now!", "in28minute1s"));
		repository.deleteById(2l);
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));

		System.out.println(repository.findAll());

		System.out.println("\n\n\n\n");
		System.out.println(repository.findByAuthor("in28minute1s"));

	}

}
