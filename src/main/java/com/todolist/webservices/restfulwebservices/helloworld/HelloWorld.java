package com.todolist.webservices.restfulwebservices.helloworld;

public class HelloWorld {
	private String hw;
	
	public HelloWorld(String hw) {
		super();
		this.hw = hw;
	}

	public String getHw() {
		return hw;
	}

	public void setHw(String hw) {
		this.hw = hw;
	}

	
	@Override
	public String toString() {
		return "HelloWorld [hw=" + hw + "]";
	}

}
