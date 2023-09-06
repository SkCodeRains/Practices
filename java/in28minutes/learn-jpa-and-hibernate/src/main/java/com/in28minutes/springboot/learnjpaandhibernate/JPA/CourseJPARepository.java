package com.in28minutes.springboot.learnjpaandhibernate.JPA;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

	@PersistenceContext
	private EntityManager entityManager;

	void insert(Course course) {
		entityManager.merge(course);
	}

	void deleteById(long id) {
		var course = findByid(id);
		entityManager.remove(course);
	}

	public Course findByid(long id) {
		return entityManager.find(Course.class, id);
	}
}
