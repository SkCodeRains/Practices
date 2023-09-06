package com.in28minutes.springboot.learnjpaandhibernate.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String INSERT_QUERIES = """
			insert into course(id,name,author) values(?,?,?);
			""";
	private String DELETE_QUERY = """
			delete from course where id=?;
			""";
	private String SELECT_QUERY = """
			SELECT * FROM COURSE WHERE ID=?
			""";

	void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERIES, course.getId(), course.getName(), course.getAuthor());
	}

	void deleteById(long id) {
		jdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course findByid(long id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
