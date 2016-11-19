package tel_ran.concurrency.controller;


import tel_ran.concurrency.events.Cleaner;
import tel_ran.concurrency.events.ConnectionEvent;
import tel_ran.concurrency.events.DisconnectionEvent;
import tel_ran.concurrency.events.EventHandler;
import tel_ran.concurrency.generators.ConnectionGenerator;
import tel_ran.concurrency.generators.DisconnectionGenerator;

public class FlashNetworksTestAppl {
	static EventHandler eventHandler = new EventHandler();
	static ConnectionEvent[] connectionEvents = new ConnectionEvent[3];
	static DisconnectionEvent[] disconnectionEvents = new DisconnectionEvent[3];
	static Cleaner cleaner;
	static long nIterations = 100000;
	static int nThreads = 3;
	static long lifeTime = 200L;// Object life time? after this time, remove connection
	static int connectionsLimit = 100000;// Max LinkedHashMap size on overflow remove oldest connection
	static int printLogType = 1;// 0-without Log, 1-short Log, 2-full Log
	
	 public static void main(String[] args) {
		 eventHandler.init(lifeTime, connectionsLimit, printLogType);
		 createThreads();
		 ConnectionGenerator connectionGenerator = new ConnectionGenerator(eventHandler, nIterations);
		 connectionGenerator.start();
		 DisconnectionGenerator disconnectionGenerator =  new DisconnectionGenerator(eventHandler, nIterations);
		 disconnectionGenerator.start();
		 
	}
	
	private static void createThreads() {
		
		for (int i = 0; i < 3; i++) {
			connectionEvents[i] = new ConnectionEvent(eventHandler,"Thread="+i);
			connectionEvents[i].start();
			disconnectionEvents[i] = new DisconnectionEvent(eventHandler,"Thread="+i);
			disconnectionEvents[i].start();
		}
		cleaner = new Cleaner(eventHandler);
		cleaner.start();
	}
}
