package tel_ran.concurrency.operations;

import tel_ran.messaging.MessageBoxQueue;

public class OperationsThread extends Thread {

	OperationMessageBox box;
	
	public OperationsThread(OperationMessageBox box) {
		this.box = box;
		setDaemon(true);
	}
	
	@Override
	public void run() {
		while (true) {
			MessageBoxQueue queue = box.mesBoxQueue;
			String operations = queue.getMessage();
			if ((operations.equals(null))||(operations.equals(""))) continue;
			box.opDelegate.performOperation(operations);
		}
	}

}
