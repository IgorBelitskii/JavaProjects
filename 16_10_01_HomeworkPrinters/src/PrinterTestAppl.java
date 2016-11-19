import java.io.IOException;

public class PrinterTestAppl {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		int numThreads = Integer.parseInt(args[0]);
		Printer[] printers = new Printer[numThreads];
		//initializing
		for (int i = 0; i <numThreads; i++) {
			printers[i] = new Printer(i);

		}
		//setting which printer notify
		for (int i = 0; i < numThreads-1; i++) {
			printers[i].setPrinter(printers[i+1]);
			if (i!=0) printers[i].start();
		}
		//setting cycle threads
		printers[numThreads-1].setPrinter(printers[0]);
		printers[numThreads-1].start();
		printers[0].start();
		
		
		synchronized (printers[0]) {
			printers[0].notify();
			
		}
	
		}
		
}


