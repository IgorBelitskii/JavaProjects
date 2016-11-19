package tel_ran.concurrency.events;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import tel_ran.concurrency.data.ExtConnData;

public class EventHandler {
	public long lifeTime = 200L;// Object life time? after this time, remove connection
	public int connectionsLimit = 100000;// Max LinkedHashMap size on overflow remove oldest connection
	public int printLogType = 2;// 0-without Log, 1-short Log, 2-full Log
	public int removedOnLimit=0;
	public int cleaned=0;
	public LinkedHashMap<String,ExtConnData> connections = new LinkedHashMap<>(); 
	public LinkedList<String> eventsToStart = new LinkedList<>();
 	public LinkedList<String> eventsToEnd = new LinkedList<>();
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
	
	public int getConnectionsSize() {
		int size;
		try {
			size = connections.size();
		} catch (Exception e) {
			return 0;
		}
		return size;
	}
	
	public void startConnection(ExtConnData extConnData) {
//		while(extConnData == null) {
//			try {
//				connections.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		String key = extConnData.getSourceHostName() + " " + extConnData.getDestinationHostName();
		
		removeIfLimit();
		if(connections.containsKey(key)) {
			connections.remove(key);
			printLog(null, "Removed object copy");
		}
		connections.put(key , extConnData);
		printLog(extConnData, "Add connection");	
		//connections.notify();
		
	}

	private void removeIfLimit() {
		while(true) {
			if(connections.size() >= connectionsLimit) {
				ExtConnData removed =connections.remove(connections.keySet().iterator().next());
				printLog(removed, "Connections owerflow! Oldest object with id-"+removed.getConnData().getId()+" removed!");
				removedOnLimit++;
			}
			else break;
		}
		
	}
	
	
	public long removeExpired(long controlDate) {
		
		Iterator<Entry<String, ExtConnData>> iterator = connections.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, ExtConnData> data = iterator.next();
			long time = data.getValue().getConnData().getStartDate().getTime();
			if(time < controlDate) {
				ExtConnData removed = data.getValue(); 
				iterator.remove();
				printLog(removed, "Object removed after "+format.format(new Date(lifeTime))+".");
				cleaned++;
			}
		}
		
		if(iterator.hasNext()) {
			return lifeTime - (System.currentTimeMillis() - iterator.next().getValue().getConnData().getStartDate().getTime());
		}
		return 0;
	}

	private void printLog(ExtConnData removed, String cause) {
		
		switch(printLogType) {
		case 1:
			System.out.println("____________________________________________________________");
			String message = "---------------------Action:"+cause;
			System.out.println(message);
			break;
		case 2:
			System.out.println("____________________________________________________________");
			String mess = removed.toString() +" \n---------------------Action:"+cause;
			System.out.println(mess);
			break;
		default:
			break;
		}
		
	}

	public void endConnection(String key) {
		try {
			connections.get(key).getConnData().setFinishDate(new Date());
			ExtConnData removed = connections.remove(key);
			printLog(removed,"End connection");
		} catch (NullPointerException e) {
			printLog(null,"Object "+key+" not found!");
		}
	}
	
	public synchronized void addStartEvent(String data) {
			eventsToStart.add(data);
			eventsToStart.notify();
	}
	
	public synchronized void addEndEvent(String data) {
			eventsToEnd.add(data);
			eventsToEnd.notify();
	}

	public void init(long lifeTime, int connectionsLimit,int printLogType) {
		this.lifeTime = lifeTime;
		this.connectionsLimit = connectionsLimit;
		this.printLogType = printLogType;
	}
}
