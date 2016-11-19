package tel_ran.messaging;
/**
 * ������� ��� ��������������� notify
 * �� �� ���������� �� ������ �������� ��� �������
 * ������� 
 * 
 * � ��� ������� �� ���� ���������
 * 
 * 
 * Notify all ������� ����� ��� thread �������� ���������� ���������
 * 
 * @author Igor
 *
 */
public class MessageBox {
	private String message; // ����� ������� ����������
	/*
	 * LINKEDLIST
	 * ����������  add ��������� � �����
	 * getmessage - delete - ����� ������ � �������
	 * ��� - �������
	 * Durable - ��� ��������� ��������
	 * 
	 * */
	
	
	synchronized public void putMessage(String message) {
		while (this.message!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
			}
		}
		this.message=message;
		this.notify();
	}
/*	synchronized public void putMessage(String message) {
		while (this.message!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
			}
		}
		this.message=message;
		this.notify();
	}*/
synchronized public String getMessage(){
	
	while(this.message==null) {
		try {
			this.wait();
		} catch (InterruptedException e) {
				System.out.println("Thread "+Thread.currentThread().getName()+" was interrupted");
		}	
	}
	String message=this.message;
	this.message=null;
	
	this.notifyAll();
	return message;
	
}
}
