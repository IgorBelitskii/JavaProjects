
public class Counters extends Thread {

	static long count1=0;
	static long count2=0;
	static long nIterations=1000;
	static Object monitor1= new Object();
	static Object monitor2 = new Object();
	/*synchronized*/ static private void increment1() {
		synchronized (monitor1) {
			count1++;
		}
	}
	/*synchronized*/ static private void increment2() {
		synchronized (monitor2) {
			count2++;
		}
	}
	public static long getCount1() {
		return count1;
	}
	public static long getCount2() {
		return count2;
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
