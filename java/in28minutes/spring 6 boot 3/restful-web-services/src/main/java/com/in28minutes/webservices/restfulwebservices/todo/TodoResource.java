package com.in28minutes.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {

	class Message {
		boolean success;

		Todo savedTodo;

		@SuppressWarnings("unused")
		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public void setSavedTodo(Todo savedTodo) {
			this.savedTodo = savedTodo;
		}

		@SuppressWarnings("unused")
		public Todo getSavedTodo() {
			return savedTodo;
		}
	}

	private TodoService service;

	TodoResource(TodoService service) {
		this.service = service;
	}

	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return service.findByUsername(username);
	}

	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
		return service.findById(id);
	}

	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Object> deleteTodo(@PathVariable String username, @PathVariable int id) {
		service.deleteById(id);

		Message message = new Message();
		message.setSuccess(true);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PutMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Object> updateTodo(@PathVariable String username, @PathVariable int id,
			@RequestBody Todo todo) {

		Todo savedTodo = service.findById(id);

		savedTodo.setDescription(todo.getDescription());
		savedTodo.setTargetDate(todo.getTargetDate());

		Message message = new Message();
		message.setSuccess(true);
		message.setSavedTodo(savedTodo);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PostMapping(path = "/users/{username}/todos")
	public ResponseEntity<Object> addTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		Todo savedTodo = service.addTodo(todo);

		Message message = new Message();
		message.setSuccess(true);
		message.setSavedTodo(savedTodo);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

}
