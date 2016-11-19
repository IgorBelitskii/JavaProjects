package tel_ran.communication;

import tel_ran.messaging.MessageBoxQueue;

public class Receiver extends Thread {
	private MessageBoxQueue messageBox;
	public Receiver(MessageBoxQueue messageBox){
		this.messageBox=messageBox;
		setDaemon(true);
	}
	
@Override
public void run (){
	while(true){
		System.out.println(getName()+" "+messageBox.getMessage());
	}
}
}
