
public class Printer implements Runnable {
	private static final char DEFAULT_SYMB = '*';
	private static final int DEFAULT_N_ITERATIONS = 100;
	private char symb=DEFAULT_SYMB;
	private int nIterations=DEFAULT_N_ITERATIONS;
	

	public Printer(char symb, int nIterations) {
		super();
		this.symb = symb;
		this.nIterations = nIterations;
	}


	public Printer() {
		super();
		this.symb = symb;
		this.nIterations = nIterations;
		
	}


	@Override
	public void run() {
		for (int i = 0; i < nIterations; i++) {
			System.out.println(symb+" "+Thread.currentThread().getName());
			pause(10);
		}
		
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
