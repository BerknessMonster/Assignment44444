import java.util.Scanner;
/////fix users so they can be accessed in every class, maybe constants?


public class UserClientChoices {
	private Scanner choicesScanner = new Scanner(System.in);
	

	public String choicesUsernameUpdate() {
		System.out.println("Which user would you like to login as? (Type in a valid username)");
		String usernameUpdate = choicesScanner.nextLine();
		System.out.println(usernameUpdate);
		return usernameUpdate;
	}

	public void choicesUpdateName(User loggedInUser) {
		System.out.println("Please type in your new name: ");
		String name = choicesScanner.nextLine();
		loggedInUser.setName(name);
	}

	public void choicesUpdatePassword(User loggedInUser) {
		System.out.println("Please type in your new password: ");
		String password = choicesScanner.nextLine();
		loggedInUser.setPassword(password);
	}

	public void choicesUpdateUsername(User loggedInUser) {
		System.out.println("Please type in your new username: ");
		String username = choicesScanner.nextLine();
		loggedInUser.setUsername(username);
	}

	public int choiceOptions(User loggedInUser) {
		System.out.println("................");
		System.out.println("Please choose from the following options:");
		if (loggedInUser instanceof SuperUser) {
			System.out.println("(0) Log in as another user ");
		}
		System.out.println("(1) Update username");
		System.out.println("(2) Update password");
		System.out.println("(3) Update name");
		System.out.println("(4) Exit");
		Integer option = choicesScanner.nextInt();
		
		return option;

	}

}
