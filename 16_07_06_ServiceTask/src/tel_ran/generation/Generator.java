package tel_ran.generation;

import java.util.Random;

import tel_ran.service.Task;

public class Generator {
	int maxDuration, minDuration, probabilityOfGeneration;

	public Generator(int minDuration, int maxDuration, int probabilityOfGeneration) {
		this.maxDuration = maxDuration;
		this.minDuration = minDuration;
		this.probabilityOfGeneration = probabilityOfGeneration;
	}
	
	public Task generate(int time) {
		int duration, probability;
		Random random = new Random();
		probability=random.nextInt(100);
		if (probability<=probabilityOfGeneration) return null;
		duration=minDuration+random.nextInt(maxDuration-minDuration);// random between minDuration and maxDuration
		Task task=new Task(time,duration);
		return task;
	}

}
