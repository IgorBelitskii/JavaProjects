package tel_ran.messaging;
/**
 * –ешение без дополнительного notify
 * ћы не пропускаем ни одного мессаджа без нотифай
 * ќчередь 
 * 
 * и еще вариант по двум мониторам
 * 
 * 
 * Notify all сделать чтобы все thread получили одинаковое сообщение
 * 
 * @author Igor
 *
 */
public class MessageBox {
	private String message; // здесь сделать линкедлист
	/*
	 * LINKEDLIST
	 * путмессадж  add добавл€ем в конец
	 * getmessage - delete - берем первый и удал€ем
	 * тип - о„≈–≈ƒ№
	 * Durable - все сообщени€ хран€тс€
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
