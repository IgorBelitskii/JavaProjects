

public class Tarakan implements Runnable {
private static int distance;
private static int maxSleepingTime;
private static int winnerNumber=0;
private int tarakanNumber;
public static long startTime;
public long endTime;

private static Object object1=new Object();
public static void setDistance(int distance) {
	Tarakan.distance = distance;
}


public Tarakan(int tarakanNumber) {
	this.tarakanNumber = tarakanNumber;
}

public static void setMaxSleepingTime(int maxSleepingTime) {
	Tarakan.maxSleepingTime = maxSleepingTime+1;
}

	public void run() {
		for(int i=0; i<distance; i++){
			System.out.println(tarakanNumber);
			try {
				Thread.sleep
		(1+(int)(Math.random()*maxSleepingTime));
			} catch (InterruptedException e) {
				
			}
		}
		synchronized(object1) {
		findWinner(tarakanNumber);
		}
	}

	private static void findWinner(int tarakanNumber){
		if(winnerNumber==0)
			winnerNumber=tarakanNumber;
	}

	public  static int getWinnerNumber() {
		return winnerNumber;
	}

	

}
/**
 * Реализовать таблицу результатов
 * и время показанное тараканом
 * 
 * 
 * 2-я задача
 * 
 * 
 * параллельная сортировка (пузырьковаz) BubbleSorting
 * 100 000 элементов делится на группы
 * кол-во thread - параметр
 * 
 * например 100 потоков каждый THREAD сортирует свою часть
 * 
 * а потом все части соединяются
 * 
 * У thread ов ссылка на один и то же массив.
 * и индексы с какого по какой(по какой не включается)
 * т.к. каждый синхронизирует свою часть самостоятельно
 * Arrays.sort(int [] ar, int from, int to)
 * to - not inclusive
 * 
 * 
 * ((((((a+b)+c)+d)+e)...)
 * 
 * 
 * Функция Merge сортирует
 * 
 *  5 8 20 50
 *  
 *  6 7 30 35
 *  
 *  формируем дополнительный массив
 *  перемещая индексы этих двух массивов
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
