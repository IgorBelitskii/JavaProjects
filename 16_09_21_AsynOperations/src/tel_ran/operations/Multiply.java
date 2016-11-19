package tel_ran.operations;

public class Multiply extends BinaryArithmeticOperations {

@Override
public void performOperation(String parameters) {
	try {
		Thread.currentThread().sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	double[] numbers = splitParameters(parameters);
	double result= numbers[0]*numbers[1];

	
	System.out.println("Result of operation "+operationName+" is "+result);
}

public Multiply() {
	super();
	super.operationName="Multiply";
}
}
