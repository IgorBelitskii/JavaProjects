package events.controller;
import flash.generators.ConnectionGenerator;
import flash.generators.DisconnectionGenerator;
import flash.handler.EventHandler;
import flash.threads.Cleaner;
import flash.threads.ThreadEnd;
import flash.threads.ThreadStart;

public class EventControllerAppl {
	static int nThreads = 1;
	public static void main(String[] args) {
		EventHandler handler = new EventHandler();
	/*	ThreadStart[] StartingThreads = new ThreadStart[nThreads];
		ThreadEnd[] EndingThreads = new ThreadEnd[nThreads];
		for (int i = 0; i < nThreads; i++) {
			StartingThreads[i] = new ThreadStart(handler);
			StartingThreads[i].run();
			EndingThreads[i] = new ThreadEnd(handler);
			EndingThreads[i].run();
		}*/
		ConnectionGenerator cGenerator = new ConnectionGenerator(handler, 1000);
		DisconnectionGenerator dGenerator = new DisconnectionGenerator(handler, 1000);
		ThreadStart START = new ThreadStart(handler);
		ThreadEnd END = new ThreadEnd(handler);
		Cleaner cleaner = new Cleaner(handler);
		START.start();
		END.start();
		cGenerator.start();
		dGenerator.start();
		cleaner.start();
		
	}
}
