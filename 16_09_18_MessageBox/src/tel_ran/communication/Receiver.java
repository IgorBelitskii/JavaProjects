package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Receiver extends Thread {
	
	private MessageBox messageBox;
	
	public Receiver(MessageBox messageBox) {
		this.messageBox=messageBox;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(getName()+" "+messageBox.getMessage());
		}
	}
}
