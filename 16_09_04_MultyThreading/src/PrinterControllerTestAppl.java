/**
 * �������� ���������� ����
 * ������� - thread
 * � thread - ���� - ���-�� �������� ������� ���������
 * ������ ��� ���� �������� ��������� ����������� � ������������ ����� �������� (Sleep)
 * �������� ����� ������� ����.
 * 
 * � �������� �������� ����� ��������
 * 
 * ���� ������ - 
 * ���������� ����������
 * ���������� ���������� Congratulations N-X
 * 
 * 
 * � �������� �������� ���-�� ���������
 * ��� � ���� ����� � ms
 * 
 * 
 * 
 * 
 *
 */


public class PrinterControllerTestAppl {

	public static void main(String[] args) throws InterruptedException {
		
		Printer[] printers={new Printer('&',100), new Printer('*',100)};
		long time=System.currentTimeMillis();
		
		joinPrinters(startPrinters(printers));
		System.out.println(System.currentTimeMillis()-time);
	}

	private static void joinPrinters(Thread[] startPrinters) throws InterruptedException {
		for(int i=0; i<startPrinters.length; i++) {
			startPrinters[i].join();
		}
		
	}

	private static Thread[] startPrinters(Printer[] printers) {
		Thread[] threads = new Thread[printers.length];
		for (int i = 0; i < printers.length; i++) {
			threads[i]=new Thread(printers[i]);
			threads[i].start();
		} 
		return threads;
	}

}
