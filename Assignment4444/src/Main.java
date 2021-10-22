
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private static UserService userService = new UserService();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		User[] users = new User[20];
		UserClientChoices userClientChoices = new UserClientChoices();
		FileReadAndWrite fileReadAndWrite = new FileReadAndWrite();
		User loggedInUser = null;
		int loginAttempts = 1;
		
		fileReadAndWrite.fileReader(users);
		//fileReadAndWrite.fileWriter();
		
		while (loggedInUser == null && loginAttempts < 5) {
			System.out.println("Enter your email:");
			String username = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			loggedInUser = userService.getValidUser(username, password, users);
			if (loggedInUser == null) {
				System.out.println("Invalid login, please try again");
				loginAttempts++;
				if (loginAttempts >= 5) {
					System.out.println("Too many failed login attempts, you are now locked out.");
					System.exit(1);
				}
			}
		}

		if (loggedInUser != null) {
			int option = 0;
			///switched this while loop down below :)
			while (loggedInUser != null) {
				System.out.println("Welcome: " + loggedInUser.getName());
				option = userClientChoices.choiceOptions(loggedInUser);
				if (option == 0 && "super_user".equals(loggedInUser.getRole())) {
					String usernameToUpdate = userClientChoices.choicesUsernameUpdate();
					User userToUpdate = userService.getUserByUsername(usernameToUpdate);
					if (userToUpdate == null) {
						System.out.println("Invalid username.");
					} else {
						loggedInUser = userToUpdate;
						return;
					}
				} else if (option == 1) {
					userClientChoices.choicesUpdateUsername(loggedInUser);
				} else if (option == 2) {
					userClientChoices.choicesUpdatePassword(loggedInUser);
				} else if (option == 3) {
					userClientChoices.choicesUpdateName(loggedInUser);
				} else if (option != 4) {
					System.out.println("Invalid input, try again");
				}
			}
		}
	}
}
