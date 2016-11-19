package tel_ran.concurrency.tests;

import org.junit.Before;
import org.junit.Test;

import tel_ran.concurrency.events.Cleaner;
import tel_ran.concurrency.events.ConnectionEvent;
import tel_ran.concurrency.events.DisconnectionEvent;
import tel_ran.concurrency.events.EventHandler;
import tel_ran.concurrency.generators.ConnectionGenerator;
import tel_ran.concurrency.generators.DisconnectionGenerator;

public class FlashNetworksTests {
	 long nIterations = 100000;
	 int nThreads = 3;
	 long lifeTime = 500L;// Object life time? after this time, remove connection
	 int connectionsLimit = 100;// Max LinkedHashMap size on overflow remove oldest connection
	 int printLogType = 0;// 0-without Log, 1-short Log, 2-full Log
	 private long working_time = 1000;
	 
	 EventHandler eventHandler = new EventHandler();
	 ConnectionEvent[] connectionEvents = new ConnectionEvent[nThreads];
	 DisconnectionEvent[] disconnectionEvents = new DisconnectionEvent[nThreads];
	 Cleaner cleaner;
	 
	 
	 ConnectionGenerator connectionGenerator = new ConnectionGenerator(eventHandler, nIterations);
	 DisconnectionGenerator disconnectionGenerator =  new DisconnectionGenerator(eventHandler, nIterations);

	 int expectedId = 1;
	 String startConnectionString = "sourceIp" + expectedId + ":SourcePort" + expectedId + " DestIp" + expectedId + ":DestPort" + expectedId + " " + expectedId;
	
	private void createThreads() {
		for (int i = 0; i < nThreads; i++) {
			connectionEvents[i] = new ConnectionEvent(eventHandler,"Start-"+i);
			disconnectionEvents[i] = new DisconnectionEvent(eventHandler,"End-"+i);
			connectionEvents[i].start();
			disconnectionEvents[i].start();
		}
		cleaner = new Cleaner(eventHandler);
	}
	
	
	@Before
	public void setUp() throws Exception {
		createThreads();
		eventHandler.init(lifeTime, connectionsLimit, printLogType);
	}

	
	@Test
	public void testStartEndConnectionsCount() {
		
		cleaner.start();
		connectionGenerator.start();
		disconnectionGenerator.start();
		try {
			Thread.sleep(working_time);
			
		} catch (InterruptedException e) {}
		connectionGenerator.interrupt();
		disconnectionGenerator.interrupt();
		
		System.out.println("Init parameters:\n"
				+"Working time= "+working_time + " mills;\n"
				+"nIterations = "+nIterations+"\n"
				+"StartEvent = " +nThreads+" Threads \n"
				+"EndEvent = " +nThreads+" Threads \n"
				+"lifeTime = " +lifeTime+ " mills;\n"
				+"connectionsLimit = " +connectionsLimit+"\n"
				+"LogType = " + (printLogType == 2? "full Log":(printLogType != 1? "without Log":"short Log")));
		
		System.out.println("___________________________________________________________");
		for (int i = 0; i < nThreads; i++) 
			System.out.println(connectionEvents[i].name+" put-"+connectionEvents[i].id+" connections.");
		for (int i = 0; i < nThreads; i++) 
			System.out.println(disconnectionEvents[i].name +" end-"+disconnectionEvents[i].id+" connections.");
		
		System.out.println("___________________________________________________________");
		System.out.println("connection Generator generate-"+connectionGenerator.id + " events;");
		System.out.println("disconnection Generator generate-"+disconnectionGenerator.id  + " events;");
		System.out.println("Cleaner remove-"+ eventHandler.cleaned  + " events;");
		System.out.println("Removed on limit-"+ eventHandler.removedOnLimit  + " events;");
		System.out.println("LinkedHashMap size-"+eventHandler.connections.size()+";");
		System.out.println("___________________________________________________________");
	}

}
