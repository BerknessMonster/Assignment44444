import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReadAndWrite {
	static User[] users = new User[20];
	private static UserService userService = new UserService();
	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("users.txt"));

			String line = null;
			int i = 0;
			while ((line = reader.dataLine()) != null) {
				String[] values = line.split(", ");
				if ("super_user".equals(values[3])) {
					users[i+1] = new SuperUser(values[0], values[1], values[2]);
				} else {
					users[i+1] = new NormalUser(values[0], values[1], values[2]);
				}
			}

		} finally {
			if (reader != null)
				reader.close();
		}

	
	
}
	BufferedWriter writer = null;
	try {
		writer = new BufferedWriter(new FileWriter("users.txt"));
		Arrays.sort(users);
		
		for (User user : users) {
			writer.write(userService.getCsvOutput(user));
		}
	} finally {
		if (writer != null) {
			writer.close();
		}
	}
}

}
