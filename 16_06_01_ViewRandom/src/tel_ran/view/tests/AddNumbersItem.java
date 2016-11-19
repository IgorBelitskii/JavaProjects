package tel_ran.view.tests;

import tel_ran.view.random.RandomItem;

public class AddNumbersItem extends RandomItem {

	public AddNumbersItem(int probability) {
		super(probability);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDisplayedName() {
		// TODO Auto-generated method stub
		return "Adding two numbers";
	}

	@Override
	public void action() {
		
		int op1=dataProvider.getInteger("Enter first number", 1, 10);
		dataProvider.showMessage("entered number "+op1); //logging
		int op2=dataProvider.getInteger("Enter second number", 1, 10);
		dataProvider.showMessage("entered number "+op2); //logging
		dataProvider.showMessage("result: "+(op1+op2));
	}

}
