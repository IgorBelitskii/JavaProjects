package tel_ran.messaging;
import java.util.*;
public class MessageBoxQueue {
private LinkedList<String> messageBox=new LinkedList<>();
synchronized public void putMessage(String message){
	
	messageBox.add(message);
	this.notify();
}
synchronized public String getMessage(){
	while(messageBox.isEmpty()){
		try {
			this.wait();
		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted ");
		}
	}
	String message=messageBox.removeFirst();
	return message;
}
}
