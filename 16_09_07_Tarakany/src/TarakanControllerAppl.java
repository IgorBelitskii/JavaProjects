
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *  * Ќаписать тараканные бега
 * таракан - thread
 * ¬ thread - цикл - кол-во итераций которое пробегает
 *  аждый шаг есть ожидание случайное минимальное и максимальное врем€ ожидание (Sleep)
 * ожидание после каждого шага.
 * 
 * ¬ итерации печатаем номер “аракана
 * 
 * —уть задачи - 
 * определить победител€
 * Ќапечатать победител€ Congratulations N-X
 * 
 * 
 * — консолои задаютс€ кол-во тараканов
 * мин и макс врем€ в ms

 */
public class TarakanControllerAppl {
	

	private static final int distance = 20;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Please input number of tarakans");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(reader.readLine());
		System.out.println("Please input minTime");
		int minTime = Integer.parseInt(reader.readLine());
		System.out.println("Please input maxTime");
		int maxTime = Integer.parseInt(reader.readLine());
		Tarakan [] tarakans = new Tarakan[x];
		for (int i = 0; i < x; i++) {
			tarakans[i]=new Tarakan(minTime,maxTime,i,distance);
			
		}
		Thread[] threads = startTarakans(tarakans);
		while(true){
			int k=0;
			for (Thread thread : threads) {
				if (thread.isAlive()==false) k++;
			}
			if (k==threads.length) break;
		}
		long min=tarakans[0].timeFinish;
		int num = 0;
		for(Tarakan tarakan: tarakans) {
			if (tarakan.timeFinish<min){
				min=tarakan.timeFinish;
				num=tarakan.number;
			}
		}
		System.err.println("Congratulations, tarakan number "+num);
		
	}
			
	public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		
	private static Thread[] startTarakans(Tarakan[] tarakans) {
		Thread[] threads = new Thread[tarakans.length];
		for (int i = 0; i < tarakans.length; i++) {
			threads[i]=new Thread(tarakans[i]);
			threads[i].start();
		} 
		return threads;
	}

}
