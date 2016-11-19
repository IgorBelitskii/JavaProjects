package flash.threads;

import java.util.Date;

import flash.events.ConnData;
import flash.events.ExtConnData;
import flash.handler.EventHandler;

public class ThreadEnd extends Thread {
	EventHandler handler;

	public ThreadEnd(EventHandler handler) {
		super();
		this.handler = handler;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (handler.events2End) {
				while (handler.events2End.isEmpty()) {
					try {
						handler.events2End.wait();
					} catch (InterruptedException e) {
						break;
					}
				}
				// Parsing
				String event = handler.events2End.removeFirst();
				ExtConnData extConnData = ParseEvent(event);
				String hash = extConnData.getHashKey();
				synchronized (handler.events) {
					if (handler.events.containsKey(hash)) {
						ExtConnData extdata = handler.events.remove(hash);
						extdata.connData.Finish = new Date();
						System.out.println("Object " + hash + " started at" + extdata.connData.Start + ", date finish: "
								+ extdata.connData.Finish + "removed from the database");
					}
				}
			}
		}
	}

	private ExtConnData ParseEvent(String event) {
		String parameters[] = event.split(" ");
		ConnData conData = new ConnData(new Date(), parameters[2]);
		ExtConnData extConnData = new ExtConnData(parameters[0], parameters[1], conData);
		return extConnData;
	}

}
