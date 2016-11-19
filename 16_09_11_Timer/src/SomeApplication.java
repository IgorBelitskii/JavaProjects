
public class SomeApplication {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		timer.start();
		someFunction();

	}

	private static void someFunction() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
