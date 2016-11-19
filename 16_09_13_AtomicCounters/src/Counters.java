import java.util.concurrent.atomic.AtomicLong;

public class Counters extends Thread {

	static AtomicLong count1=new AtomicLong(0);
	static AtomicLong count2=new AtomicLong(0);
	static long nIterations=1000;
//	static Object monitor1= new Object();
//	static Object monitor2 = new Object();
	/*synchronized*/ static private void increment1() {
		synchronized (count1) {
			count1.incrementAndGet();
		}
	}
	/*synchronized*/ static private void increment2() {
		synchronized (count2) {
			count2.incrementAndGet();
		}
	}
	public static long getCount1() {
		return count1.get();
	}
	public static long getCount2() {
		return count2.get();
	}
	public static void setnIterations(long nIterations) {
		Counters.nIterations = nIterations;
	}
	
	@Override
	public void run(){
		for(long i=0; i<nIterations; i++) {
			increment1();
			increment2();
		}
	}
}
