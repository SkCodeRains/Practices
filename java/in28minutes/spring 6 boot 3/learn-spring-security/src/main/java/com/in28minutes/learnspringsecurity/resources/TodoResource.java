package com.in28minutes.learnspringsecurity.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {

	public TodoResource() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/todos")
	public List<Todo> getMessage() {
		return List.of(new Todo("in28minutes", "Learn Aws"), new Todo("in28minutes", "Learn Aws"),
				new Todo("in28minutes", "Learn Aws"));
	}

}

record Todo(String username, String description) {
}