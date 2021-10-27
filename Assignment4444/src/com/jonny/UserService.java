package com.jonny;

public class UserService {
	

	public User getValidUser(String username, String password, User[] users, User loggedInUser) {
		for (User user : users) {
			System.out.println(user);
			if (user.getUsername().trim().equalsIgnoreCase(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}

	public User getUserByUsername(String username, User[] users ) {
		//FileReadAndWrite fileReadAndWrite = new FileReadAndWrite();
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				System.out.println(user);
				return user;
			}
		}
		return null;
	}

	public String getCsvOutput(User user) {
		return user.getUsername() + ", " + user.getPassword() + ", " + user.getName() + ", " + user.getRole() + "\n";
	}

}