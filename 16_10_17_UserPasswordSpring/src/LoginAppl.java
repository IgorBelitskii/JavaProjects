import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LoginAppl {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		Map<String, String> users = (Map) ctx.getBean("users");
		Console console = System.console();
		   if (console == null) {
		        System.out.println("Couldn't get Console instance");
		        System.exit(0);
		    }

		while (true) {
			console.printf("Please enter your username:");
			String username = console.readLine();
			if (username == null || username.length() == 0 || "exit".equals(username))
				break;
			String passwordReal;
			passwordReal = users.get(username);
			if (passwordReal == null)
				System.out.println("There is no such a user");
			else {
				console.printf("Please enter your password: ");
				char[] passwordChars = console.readPassword();
				String passwordString = new String(passwordChars);
				if (passwordString.equals(passwordReal))
					console.printf("User %s succesfully logined to system\n", username);
				else
					console.printf("You entered wrong username/password combination\n");
			}
			console.printf("Bye\n");
			break;
		}
	}

}
