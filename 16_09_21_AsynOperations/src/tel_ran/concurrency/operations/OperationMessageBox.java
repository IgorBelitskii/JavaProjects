package tel_ran.concurrency.operations;

import tel_ran.messaging.MessageBoxQueue;
import tel_ran.operations.OperationsDelegate;

public class OperationMessageBox {

	public MessageBoxQueue mesBoxQueue;
	public OperationsDelegate opDelegate;
	
	public OperationMessageBox(MessageBoxQueue mesBoxQueue, OperationsDelegate opDelegate) {
		super();
		this.mesBoxQueue = mesBoxQueue;
		this.opDelegate = opDelegate;
	}
	
	
}
