package tel_ran.view;

public class ViewRandomConsole implements View {

	@Override
	public String getStringValue(String message) {
		// TODO Auto-generated method stub
		return "string";
	}

	@Override
	public int getIntValue(String message, int min, int max) throws Exception {
		System.out.println(message);
		Thread.sleep(2000);
		int res=(int) (min+Math.random()*(max-min));
		System.out.println(res);
		return res;
	}

	@Override
	public void display(String message) {
		System.out.println(message);

	}

}
