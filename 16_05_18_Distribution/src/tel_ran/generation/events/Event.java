package tel_ran.generation.events;

public class Event {

	int probability; // вероятность появления события

	public Event(int probability) {
		this.probability = probability;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}
	
}
