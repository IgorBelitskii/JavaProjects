package tel_ran.chat.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import tel_ran.chat.ChatRoom;

public class ControllerChatAppl {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beansAOP.xml");
		ChatRoom chatRoom = (ChatRoom) ctx.getBean("chat");
//		chatRoom.saySomething("Privet Vasya");
		try {
			chatRoom.saySomething("Hello Vasya AAAA HELLO hello hi Hello");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			chatRoom.replySomething("Hello Vasya AAAA HELLO hello hi Hello");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ctx.close();
	}

}
