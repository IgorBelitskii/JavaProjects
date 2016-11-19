package flash.threads;

import java.util.Date;
import java.util.Iterator;
import flash.events.ExtConnData;
import flash.handler.EventHandler;

public class Cleaner extends Thread {
	EventHandler handler;
	Long LIFETIME = 1000L;

	public Cleaner(EventHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void run() {
		Long difference=LIFETIME;
		while (true) {
			
			synchronized (handler.events) {
				Date currentTime = new Date();
				Iterator<ExtConnData> iterator = handler.events.values().iterator();			
				if (iterator.hasNext()) {
					ExtConnData extConnData;
					extConnData = iterator.next();
					Date startTime = extConnData.connData.Start;
					difference = currentTime.getTime() - startTime.getTime();

					if ((difference >= LIFETIME)) {
						iterator.remove();

						System.out.println("overTimed: Object " + extConnData.getHashKey() + " started at"
								+ extConnData.connData.Start + " removed from the database at " + new Date());
					} 
				}
				}
					if ((difference >= LIFETIME)) {
						try {
							sleep(difference);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}

		
	}


