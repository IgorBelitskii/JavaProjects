package tel_ran.concurrency.operations.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import tel_ran.concurrency.operations.OperationMessageBox;
import tel_ran.concurrency.operations.OperationsThread;
import tel_ran.messaging.MessageBoxQueue;
import tel_ran.operations.Divide;
import tel_ran.operations.FileCopy;
import tel_ran.operations.Multiply;
import tel_ran.operations.OperationsDelegate;
import tel_ran.operations.Subtract;
import tel_ran.operations.Sum;

public class OperationsAppl {
	static {
	
	}
	public static void main(String[] args) throws IOException {
		
		OperationsDelegate delegates[] = {
				new Sum(), new Subtract(), new Divide(), new Multiply(), new FileCopy() };
		
		Map<String,OperationMessageBox> mapOperations = new HashMap<String,OperationMessageBox>();
	
		for (OperationsDelegate operations: delegates) {
			mapOperations.put(operations.getOperationName(), new OperationMessageBox(new MessageBoxQueue(),operations));
		}
		
		
		for (OperationMessageBox box: mapOperations.values()) {
			new OperationsThread(box).start();
		
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input operation:");
		for (String oper: mapOperations.keySet()) {
			System.out.println(oper);
		}
		System.out.println("Type \"exit\" to exit");
		while(true) {
			System.out.println("Please input operation:");
			String line = reader.readLine();
			if (line.equalsIgnoreCase("exit")) break;
			OperationMessageBox opMessBox=mapOperations.get(line);
			System.out.println(opMessBox.opDelegate.getPrompt());
			line = reader.readLine();
			if (line.equalsIgnoreCase("exit")) break;
			opMessBox.mesBoxQueue.putMessage(line);
		}
	}
		

}

	/*
	
	}*/



