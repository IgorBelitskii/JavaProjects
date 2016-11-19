
import tel_ran.view.*;
public class TarakanRaceAppl {
	

	private static final int DISTANCE_MIN = 100;
	private static final int DISTANCE_MAX = 10000;
	private static final int SLEEPING_TIME_MAX = 10;
	private static final int N_TARAKANS_MIN = 3;
	private static final int N_TARAKANS_MAX = 10;

	public static void main(String[] args) throws Exception {
		View view=new ViewConsole();
		Tarakan.setDistance(view.getIntValue("enter distance", DISTANCE_MIN, DISTANCE_MAX));
		Tarakan.setMaxSleepingTime(view.getIntValue("enter maximal sleeping time", 1,SLEEPING_TIME_MAX));
		int nTarakans=view.getIntValue("enter number of tarakans", N_TARAKANS_MIN, N_TARAKANS_MAX);
		Thread[]threads=new Thread[nTarakans];
		for(int i=0; i<nTarakans; i++){
			threads[i]=new Thread(new Tarakan(i+1));
			threads[i].start();
		}
		for(int i=0; i<nTarakans; i++)
			threads[i].join();
		System.out.println("The winner is the Tarakan "+Tarakan.getWinnerNumber());
	}
	
}
