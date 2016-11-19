package tel_ran.concurrency.events;

import java.text.SimpleDateFormat;

public class Cleaner extends Thread {
	
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
	EventHandler eventHandler = new EventHandler();
	long lifeTime = eventHandler.lifeTime;
	long timeToCheck = lifeTime;
	
	
	public Cleaner(EventHandler eventHandler) {
		super();
		this.eventHandler = eventHandler;
		setDaemon(true);
	}

	@Override
	public void run() {
		while(true) {
			synchronized (eventHandler.connections) {
				try {
					sleep(timeToCheck);
				} catch (InterruptedException e) {}
				
				long nextTime =eventHandler.removeExpired(System.currentTimeMillis() - lifeTime);
				timeToCheck = nextTime > 0 ? nextTime : 0 ;
				
			}	
		}
	}
}
