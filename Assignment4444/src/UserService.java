
public class UserService {
	FileReadAndWrite fileReadAndWrite = new FileReadAndWrite(User[] users);
	

	public User getValidUser(String username, String password, User[] users) {
		for (User user : Main.users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User getUserByUsername(String username) {
		for (User user : fileReadAndWrite.users) {
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