import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class FileReadAndWrite {
	private static UserService userService = new UserService();
	

	public User[] fileReader(User[] users) throws IOException {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("src/users.txt"));

			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(", ");
				if ("super_user".equals(values[3])) {
					users[i + 1] = new SuperUser(values[0], values[1], values[2]);
				} else {
					users[i + 1] = new NormalUser(values[0], values[1], values[2]);
				}
			}

		} finally {
			if (reader != null)
				reader.close();
		}
		return users;

	}
    public void fileWriter(User[] users) {
    	BufferedWriter writer = null;
    	{
    		try {
    			writer = new BufferedWriter(new FileWriter("src/users.txt"));
    			Arrays.sort(users);
    			
    			for (User user : users) {
    				writer.write(userService.getCsvOutput(user));
    			}
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		} finally {
    			if (writer != null) {
    				try {
    					writer.close();
    				} catch (IOException e) {
    					
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    	
    }

}
