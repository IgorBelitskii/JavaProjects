package tel_ran.concurrency.generators;

import java.util.Random;

import tel_ran.concurrency.events.EventHandler;

public class DisconnectionGenerator extends Thread {
	EventHandler eventHandler;
	Random random = new Random();
	
	long nIterations;
	public int id;
	
	public DisconnectionGenerator(EventHandler eventHandler, long nIterations) {
		super();
		this.eventHandler = eventHandler;
		this.nIterations = nIterations;
	}

	

	@Override
	public void run() {
		for (int i = 0; i < nIterations; i++) {
			int probability = getProbability();
			if(probability == 1)
				continue;
			else {
				try {
					sleep(probability);
					synchronized (eventHandler.eventsToEnd) {
						eventHandler.addEndEvent("sourceIp" + i + ":SourcePort" + i + " DestIp" + i + ":DestPort" + i);
						id=i;
					}
				} catch (InterruptedException e) {}
			}
		}
	}


	private int getProbability() {
		return random.nextInt(3);
	}
}
