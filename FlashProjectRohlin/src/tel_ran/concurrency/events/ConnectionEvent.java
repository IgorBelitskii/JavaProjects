package tel_ran.concurrency.events;

import java.text.SimpleDateFormat;
import java.util.Date;

import tel_ran.concurrency.data.ConnData;
import tel_ran.concurrency.data.ExtConnData;

public class ConnectionEvent extends Thread {
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
	EventHandler eventHandler = new EventHandler();
	public String name;
	public int id=0;
	
	public ConnectionEvent(EventHandler eventHandler, String name) {
		super();
		this.eventHandler = eventHandler;
		this.name = name;
		setDaemon(true);
	}

	public ExtConnData parseParameters(String data) {
		
		String[] parameters = data.split(" ");
		Date startDate = new Date();
	
		ConnData connData = new ConnData(Integer.parseInt(parameters[2]), startDate);
		return new ExtConnData(parameters[0], parameters[1], connData);
	}


	@Override
	public void run() {
		ExtConnData extConnData;
		while(true) {
			synchronized(eventHandler.eventsToStart) {
				while(eventHandler.eventsToStart.isEmpty()) {
					try {
						eventHandler.eventsToStart.wait();
					} catch (InterruptedException e) {}
				}
				extConnData = parseParameters(eventHandler.eventsToStart.removeFirst());			
			}
				
			synchronized (eventHandler.connections) {
				eventHandler.startConnection(extConnData);
				id++;
			}
		}
	}
}
