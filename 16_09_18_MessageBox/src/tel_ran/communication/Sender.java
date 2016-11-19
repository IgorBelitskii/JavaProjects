package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Sender extends Thread {
	
	MessageBox messageBox;
	int nMessages=100;
	
	
	public Sender(MessageBox messageBox) {
		super();
		this.messageBox = messageBox;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <= nMessages; i++) {
			messageBox.putMessage("message"+i);
		/*	try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}
		
	}

	public MessageBox getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(MessageBox messageBox) {
		this.messageBox = messageBox;
	}

	public int getnMessages() {
		return nMessages;
	}

	public void setnMessages(int nMessages) {
		this.nMessages = nMessages;
	}
	
}
