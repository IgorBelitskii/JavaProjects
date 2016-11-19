package tel_ran.operations;

public class Divide extends BinaryArithmeticOperations {


public Divide() {
		super();
		super.operationName = "Divide";
	}

@Override
public void performOperation(String parameters) {
	double[] numbers = splitParameters(parameters);
	double result=0;
	try {
		Thread.currentThread().sleep(5000);
		result = numbers[0]/numbers[1];
		} catch (Exception e) {
		System.out.println("Incorrect arythmetic operation");
	}
	System.out.println("Result of operation "+operationName+" is "+result);
}
}


