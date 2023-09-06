package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();

	static int count = 0;

	static {
		todos.add(new Todo(++count, "superadmin", "Learning DSA", LocalDate.now(), false));
		todos.add(new Todo(++count, "superadmin", "Learning Spring Boot", LocalDate.now(), false));
		todos.add(new Todo(++count, "superadmin", "Learning ReactJS", LocalDate.now(), false));
		todos.add(new Todo(++count, "superadmin", "Learning NextJs", LocalDate.now(), false));
		todos.add(new Todo(++count, "superadmin", "Learning Angular RXJS", LocalDate.now(), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> pre = todo -> todo.getUsername().equals(username);
		return todos.stream().filter(pre).toList();
	}

	public void addTodo(String username, String description, LocalDate targetData, boolean done) {
		todos.add(new Todo(++count, username, description, targetData, done));
	}

	public void deleteTodoById(int id) {
		/* Predicate<? super Todo> predicate = todo -> todo.getId() == id; */
		Todo todo = findTodoById(id);
		todos.remove(todo);
	}

	public Todo findTodoById(int id) {
		/*
		 * Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		 * todos.stream().filter(predicate).findFirst().get();
		 */
		return todos.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public List<Todo> getTodos() {
		return todos;
	}
}
