public class CountersController {
static final long N_ITERATIONS=10000;
static final int N_THREADS=10000;
	public static void main(String[] args) {
		Counters.setnIterations(N_ITERATIONS);
		long timeStart=System.currentTimeMillis();
		Counters[] counters=createCounters();
		joinCounters(counters);
		System.out.println("Running time="+(System.currentTimeMillis() - timeStart));
		System.out.println("counter1="+Counters.getCount1());
		System.out.println("counter2="+Counters.getCount2());
	}
	private static void joinCounters(Counters[] counters) {
		for (int i = 0; i < N_THREADS; i++) {
			try {
				counters[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static Counters[] createCounters() {
		Counters[] res = new Counters[N_THREADS];
		for (int i = 0; i < N_THREADS; i++) {
			res[i] = new Counters();
			res[i].start();
		}
		return res;
	}

}
