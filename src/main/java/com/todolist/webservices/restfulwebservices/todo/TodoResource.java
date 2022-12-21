package com.todolist.webservices.restfulwebservices.todo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.webservices.restfulwebservices.todo.Todo;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoResource {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	@GetMapping("users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		List<Todo> allTodos = todoService.findAll();
		
		return allTodos.stream()
		.filter(todo -> todo.getUsername().equals(username))
		.collect(Collectors.toList());
		
	}
	
	@DeleteMapping("users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		Todo todo = todoService.deleteById(id);
		System.out.println("in api");
		if(todo !=null) {
			System.out.println("todo not null");
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
