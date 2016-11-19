

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
 * ����������� ������� �����������
 * � ����� ���������� ���������
 * 
 * 
 * 2-� ������
 * 
 * 
 * ������������ ���������� (����������z) BubbleSorting
 * 100 000 ��������� ������� �� ������
 * ���-�� thread - ��������
 * 
 * �������� 100 ������� ������ THREAD ��������� ���� �����
 * 
 * � ����� ��� ����� �����������
 * 
 * � thread �� ������ �� ���� � �� �� ������.
 * � ������� � ������ �� �����(�� ����� �� ����������)
 * �.�. ������ �������������� ���� ����� ��������������
 * Arrays.sort(int [] ar, int from, int to)
 * to - not inclusive
 * 
 * 
 * ((((((a+b)+c)+d)+e)...)
 * 
 * 
 * ������� Merge ���������
 * 
 *  5 8 20 50
 *  
 *  6 7 30 35
 *  
 *  ��������� �������������� ������
 *  ��������� ������� ���� ���� ��������
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
