package tel_ran.concurrency.events;

public class DisconnectionEvent extends Thread {
	EventHandler eventHandler = new EventHandler();
	String operationData = null;
	public String name;
	public int id=0;
	
	
	public DisconnectionEvent(EventHandler eventHandler, String name) {
		super();
		this.eventHandler = eventHandler;
		this.name = name;
		setDaemon(true);
	}

	@Override
	public void run() {
		String key;
		while(true) {
			synchronized (eventHandler.eventsToEnd) {
				while(eventHandler.eventsToEnd.isEmpty()) {
					try {
						eventHandler.eventsToEnd.wait();
					} catch (InterruptedException e) {}
				}
				key = eventHandler.eventsToEnd.removeFirst();
			}
			synchronized (eventHandler.connections) {
				eventHandler.endConnection(key);
				id++;
			}
		}
	}
}
