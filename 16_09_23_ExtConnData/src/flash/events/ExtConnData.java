package flash.events;

public class ExtConnData {
		String sourceHostName;
		String destinationHostName;
		public ConnData connData;
		String hash;
		
		public ExtConnData(String sourceHostName, String destinationHostName, ConnData connData) {
			super();
			this.sourceHostName = sourceHostName;
			this.destinationHostName = destinationHostName;
			this.connData = connData;
			this.hash=sourceHostName+" "+destinationHostName;
			
		}
	public String getHashKey() {
		return hash;
	}
}
