package com.in28minutes.springboot.learnjpaandhibernate.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpa extends JpaRepository<CourseSpringJpa, Long> {
	List<CourseSpringJpa> findByAuthor(String author);
}
