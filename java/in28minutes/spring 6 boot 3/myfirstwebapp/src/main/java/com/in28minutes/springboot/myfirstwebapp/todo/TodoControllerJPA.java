package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	@Autowired
	private TodoRepository repository;

	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		var items = repository.findByUsername(getLogedinUser());
		model.put("todos", items);
		return "listTodos";
	}

	@GetMapping("/add-todo")
	private String showNewTodoPage(ModelMap model) {
		String name = getLogedinUser();
		Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
		model.addAttribute("todo", todo);
		return "addTodo";
	}

	@PostMapping("/add-todo")
	private String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String name = getLogedinUser();
		todo.setUsername(name);
		repository.save(todo);
		return "redirect:list-todos";
	}

	@GetMapping("/delete-todo")
	private String deleteTodoById(@RequestParam int id, ModelMap model) {
		repository.deleteById(id);
		return "redirect:list-todos";
	}

	@GetMapping("/update-todo")
	private String ShowUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = repository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addTodo";
	}

	@PostMapping("/update-todo")
	private String updateTodoById(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "addTodo";
		}
		String name = getLogedinUser();
		todo.setUsername(name);
		repository.save(todo);
		return "redirect:list-todos";
	}

	private String getLogedinUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
