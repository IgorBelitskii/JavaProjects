package tel_ran.view.tests;


import tel_ran.view.random.RandomItem;

public class StringLengthItem extends RandomItem {

	public StringLengthItem(int probability) {
		super(probability);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDisplayedName() {
		// TODO Auto-generated method stub
		return "displaying string length";
	}

	@Override
	public void action() {
		
		String [] strings= {"abcd","lmn","1234567","oooooo", "dddd"};
		String str=dataProvider.getString("select string", strings);
		dataProvider.showMessage("Selected string: "+str);
		dataProvider.showMessage("Length of string: "+str.length());

	}

}
