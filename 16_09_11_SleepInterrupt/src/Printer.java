
public class Printer extends Thread {
	String symbols; 
	int num=0;
	
	
	public Printer(int i) {
		this.symbols = i;
		this.num=0;
	}


	// �������, ������� �������� ������� ������
//	�� ���������� ��������� � ���������� �������
	
@Override
public void run() {
	while(true) {
		try {
			sleep(1000);
			if (num>=symbols.length()) num=0;
			System.out.print(symbols.toCharArray()[num]);
		} catch (InterruptedException e) {
			num++;
			continue;
		}
		
	}
}

}
