package flash.threads;

import java.util.Date;
import java.util.Iterator;

import flash.events.ConnData;
import flash.events.ExtConnData;
import flash.handler.EventHandler;

public class ThreadStart extends Thread {
	EventHandler handler;

	
	public ThreadStart(EventHandler handler) {
		super();
		this.handler = handler;
	}
	

	@Override
	public void run() {
		while(true) {
			synchronized (handler.events2Start) {
			while (handler.events2Start.isEmpty()) {
				try {
					handler.events2Start.wait();
				} catch (InterruptedException e) {
					break;
				}
			}
			// Parsing
			String event = handler.events2Start.removeFirst();
			ExtConnData extConnData = ParseEvent(event);
			String hash = extConnData.getHashKey();
			if (handler.events.containsKey(hash)) {
				ExtConnData extdata =handler.events.get(hash);
				synchronized(handler.events){
				handler.events.remove(hash);
				}
				System.out.println("Object "+hash+" started at"+ extdata.connData.Start+ " removed from the database at "+ new Date());
				}
			extConnData.connData.Start = new Date();
			synchronized(handler.events) {
			handler.events.put(hash, extConnData);		
			}
			System.out.println("Object "+hash+" started at"+ extConnData.connData.Start+" added to the database at "+ new Date());
			if (handler.events.size()>=3000) {
				Iterator<ExtConnData> iterator = handler.events.values().iterator();
				if (iterator.hasNext()) {
					ExtConnData eCD= iterator.next();
					handler.events.remove(eCD);
					System.out.println("overSized: Object "+eCD.getHashKey()+" started at"+ eCD.connData.Start+ " removed from the database at "+ new Date());;
				}
				}
			}
		}
		}


	private ExtConnData ParseEvent(String event) {
		String parameters[]= event.split(" ");
		ConnData conData = new ConnData(new Date(), parameters[2]);
		ExtConnData extConnData= new ExtConnData(parameters[0], parameters[1], conData);
		return extConnData;
	}

}
	
