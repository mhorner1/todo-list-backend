package com.todolist.webservices.restfulwebservices.todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Todo {
	private long id;
	private String username;
	private String description;
	private Date targetDate;
	private boolean isDone;

	
	
	protected Todo() {
		
	}
	
	public Todo(long id, String username, String description, String targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		try {
			this.targetDate = sdf.parse(targetDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		this.isDone = isDone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		try {
			this.targetDate = sdf.parse(targetDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
