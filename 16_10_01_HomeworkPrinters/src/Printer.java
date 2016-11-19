
public class Printer extends Thread {
	int id;
	static int portion;
	static int nPortions;
	Printer printer;
	int count=0;
	//ссылка на thread который он будит

static {
	portion=2;
	nPortions=5;
	
}
	// символы, принтер печатает текущий символ
//	по интеррапту переходит к следующему символу
	
public void setPrinter(Printer printer) {
	this.printer = printer;
}


public Printer(int id) {
		super();
		this.id = id;
	}


@Override
public void run() {

	
	while(true) {

		if ((id==0)&&(count==0)) {
	//		System.out.println("First mode started on N"+id); 
		} else {
//			System.out.println("Waiting mode on N"+id);
			try {
				synchronized (this) {
					wait();
				}
			} catch (InterruptedException e1) {
				break;
			}
			}
//		System.out.println("Notifyed N"+id);
	for (int i = 0; i < portion; i++) {
		try {
		sleep(100);
			System.out.print(id);
		} catch (InterruptedException e) {
			System.out.println();
			return;
		}
		}
		count++;
		System.out.println();
		if (count>=nPortions) this.interrupt();

		synchronized (printer) {
			printer.notify();
		}
	
	}
}
}
