import java.util.Random;

public class Tarakan implements Runnable {
	private static final int nIterations = 100000;
	int minTime=1;
	int maxTime=10;
	int number;
	int distance;
	long timeFinish;
	
	public Tarakan(int minTime, int maxTime,int number,int distance) {
		super();
		this.minTime = minTime;
		this.maxTime = maxTime;
		this.number=number;
		this.distance=distance;
	}

	public Tarakan() {

	}

	@Override
	public void run() {
		int length=0;
		for (int i = 0; i < nIterations; i++) {
			System.out.println("Tarakan number"+number+" "+Thread.currentThread().getName());
			Random x = new Random();
			int num = x.nextInt(maxTime-minTime)+minTime;
			pause(num);
			length++;
			if (length>=distance) break;
		}
		System.err.println("Tarakan number"+number+"finished");
		this.timeFinish=System.currentTimeMillis();

	}

	private void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
