package com.capgemini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {

	@Id
	private int id;
	private String name;
	private String password;
	private String email;
	private String role;
	//default constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//paramaterised constructor
	public User(int id, String name, String password, String email, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	//getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//toString 
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ "]";
	}
	
	
}
