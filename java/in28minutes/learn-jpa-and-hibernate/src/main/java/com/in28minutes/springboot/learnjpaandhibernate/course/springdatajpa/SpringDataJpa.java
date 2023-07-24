package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import java.util.List;

public interface SpringDataJpa extends JpaRepository<Course, Long> {

	List<Course> findByAuthor(String author);
}
