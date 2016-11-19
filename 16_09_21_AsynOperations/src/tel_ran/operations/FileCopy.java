package tel_ran.operations;

public class FileCopy implements OperationsDelegate {
	

	@Override
	public String getOperationName() {

		return "FileCopy";
	}

	protected String[] splitParameters(String parameters) {
		String[] strings=parameters.split(" ");
	
		return strings;
	}

	@Override
	public String getPrompt() {
		return "Please type two names of files, separated by space:";
	}

	@Override
	public void performOperation(String parameters) {
		try {
			Thread.currentThread().sleep(5000);
			String[] strings = splitParameters(parameters);
			System.out.println("Reading file "+strings[0]);
			//TODO
			System.out.println("Writing file "+strings[1]);
			//TODO
		} catch (Exception e) {
			System.out.println("Error in arguments");
		}
		
		
	}

}
