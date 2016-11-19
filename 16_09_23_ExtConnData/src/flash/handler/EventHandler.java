package flash.handler;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import flash.events.ExtConnData;

public class EventHandler {

	public LinkedHashMap <String, ExtConnData> events = new LinkedHashMap<>();
	public LinkedList<String> events2Start = new LinkedList<>();
	public LinkedList<String> events2End = new LinkedList<>();

	public void addEventStart(String data){
		synchronized(events2Start) {
		events2Start.add(data);
		events2Start.notify();
		}
	}
	public void addEventEnd(String data){
		synchronized(events2End) {
		events2End.add(data);
		events2End.notify();
		}
	}
}
