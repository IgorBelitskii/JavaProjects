package tel_ran.operations;

public abstract class BinaryArithmeticOperations implements OperationsDelegate {

	protected String operationName;

	@Override
	public String getOperationName() {
		// TODO Auto-generated method stub
		return operationName;
	}

	protected double[] splitParameters(String parameters) {
		double [] numbers = new double [2];
		String[] strings=parameters.split(" ");
		try {
			for (int i = 0; i < strings.length; i++) {
				numbers[i] = Double.parseDouble(strings[i]);
			}
		} catch (NumberFormatException e) {
			System.out.println("Entered incorrect numbers ");
		}
		return numbers;
	}

	@Override
	public String getPrompt() {
		return "Please type two numbers, separated by space:";
	}

	@Override
	public void performOperation(String parameters) {
		// TODO Auto-generated method stub
		
	}

}
