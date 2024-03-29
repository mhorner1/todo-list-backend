package com.todolist.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "maxhorner", "Learn to dance", "2022-01-01", false));
		todos.add(new Todo(++idCounter, "maxhorner", "Learn React", "2022-01-01", false));
		todos.add(new Todo(++idCounter, "maxhorner", "Learn Spring boot", "2022-01-01", false));
		todos.add(new Todo(++idCounter, "someotheruser", "Learn to make homemade cheese", "2022-01-01", false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo findById(long id) {
		return todos.stream().filter(todo -> todo.getId() == id).limit(1).collect(Collectors.toList()).get(0);
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo == null) {
			return null;
		}
		
		todos.remove(todo);
		return todo;
		
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() ==-1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	

}
