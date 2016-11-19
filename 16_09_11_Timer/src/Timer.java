import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Formatter;

public class Timer extends Thread {
	
	public Timer() {
		setDaemon(true);
	}


	@Override 
	public void run() {
		
		while (true) {
			try {
				sleep(1000);
				System.out.println(LocalDateTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
