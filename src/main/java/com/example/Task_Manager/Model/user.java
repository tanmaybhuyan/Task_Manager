package com.example.Task_Manager.Model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class user {
	@Id
	@GeneratedValue
	public int id;
	public String username;
	public String password;
	public String role;
	public Long getId() {
		return (long) id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}