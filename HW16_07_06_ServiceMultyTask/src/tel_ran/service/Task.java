package tel_ran.service;

public class Task {
	
	int enterTime, startTime, duration;
	boolean inService;
	public Task(int enterTime, int duration) {
		this.enterTime = enterTime;
		this.duration = duration;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public boolean isInService() {
		return inService;
	}
	public void setInService(boolean inService) {
		this.inService = inService;
	}
	public int getEnterTime() {
		return enterTime;
	}
	public int getDuration() {
		return duration;
	}
	

}
