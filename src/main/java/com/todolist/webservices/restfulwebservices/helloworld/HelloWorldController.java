package com.todolist.webservices.restfulwebservices.helloworld;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@Component
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String retrieveHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/helloworldbean")
	public HelloWorld retrieveHelloWorldObj() {
		return new HelloWorld("Hello World");
	}
	
	@GetMapping("/helloworld/{name}")
	public HelloWorld retrieveHelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld("Hello, " + name);
	}
	
}
