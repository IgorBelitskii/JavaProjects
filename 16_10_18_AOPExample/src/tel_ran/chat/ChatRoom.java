package tel_ran.chat;

import java.util.ArrayList;

public class ChatRoom {
	public ArrayList vulgars;

	public void saySomething(String message) {
			System.out.println(message);

	}

	public void replySomething(String message) {
			System.out.println(message + " has been replied");
		}
	}
