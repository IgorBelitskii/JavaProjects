package tel_ran.concurrency.data;

public class ExtConnData {
	 String sourceHostName;
	 String destinationHostName; 
	 ConnData connData;
	
	 public ExtConnData(String sourceHostName, String destinationHostName, ConnData connData) {
		super();
		this.sourceHostName = sourceHostName;
		this.destinationHostName = destinationHostName;
		this.connData = connData;
	}

	@Override
	public String toString() {
		return "ExtConnData [sourceHostName=" + sourceHostName + ", destinationHostName=" + destinationHostName
				+ "; \nconnData=" + connData + "]";
	}

	public String getSourceHostName() {
		return sourceHostName;
	}

	public String getDestinationHostName() {
		return destinationHostName;
	}

	public ConnData getConnData() {
		return connData;
	}

	public void setConnData(ConnData connData) {
		this.connData = connData;
	} 
	 
	 
}
