package flash.events;

import java.util.Date;

public class ConnData {
	public Date Start;
	public Date Finish;
	public String additionalInformation;
	
	public ConnData(Date start, String additionalInformation) {
		super();
		Start = start;
		this.additionalInformation = additionalInformation;
	}
	
}
