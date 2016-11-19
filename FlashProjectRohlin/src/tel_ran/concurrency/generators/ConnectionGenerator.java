package tel_ran.concurrency.generators;

import java.util.Random;

import tel_ran.concurrency.events.EventHandler;

public class ConnectionGenerator extends Thread {
	EventHandler eventHandler;
	Random random = new Random();
	long nIterations;
	public int id;
	
	
	public ConnectionGenerator(EventHandler eventHandler, long nIterations) {
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
					synchronized (eventHandler.eventsToStart) {
						StringBuilder event = new StringBuilder();
						event.append("sourceIp").append(i).append(":SourcePort").append(i).append(" DestIp").append(i).append(":DestPort")
							.append(i).append(" ").append(i);
						eventHandler.addStartEvent(event.toString());
						id = i;
					}
				} catch (InterruptedException e) {}
			}
		}
	}
	
	
	private int getProbability() {
		return random.nextInt(3);
	}
	
}
