package com.jonny;

public class User implements Comparable<User> {
	private String name;
	private String username;
	private String password;
	protected String role;

	public String getUsername() {
		return username;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int compareTo(User that) {
		if (this.name.compareTo(that.name) == 0) {
			return this.name.compareTo(that.name); 
		} else {
			return that.name.compareTo(this.name); 
		}
	}

}