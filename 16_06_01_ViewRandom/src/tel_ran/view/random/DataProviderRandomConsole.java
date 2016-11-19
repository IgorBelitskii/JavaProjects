package tel_ran.view.random;

import tel_ran.generation.events.Distribution;
import tel_ran.view.DataProvider;

public class DataProviderRandomConsole implements DataProvider {

	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);

	}

	@Override
	public String getString(String prompt, String[] stringPatterns) { // propmpt для логирования того что мы делаем
		showMessage(prompt);
		int ind =Distribution.getRandomNumber(0, stringPatterns.length-1);
		
		return stringPatterns[ind];
	}

	@Override
	public int getInteger(String prompt, int minValue, int maxValue) {
		showMessage(prompt);
		return Distribution.getRandomNumber(minValue, maxValue);
	}

}
