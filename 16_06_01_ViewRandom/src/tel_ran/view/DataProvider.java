package tel_ran.view;

public interface DataProvider {
	
	void showMessage(String message);
	String getString(String prompt, String stringPatterns[]);
	int getInteger(String prompt, int minValue, int maxValue);
	
/*
 * +showMessage(message: String); // принимает message и показывает его
+getInteger(prompt: String, minValue: int, maxValue:int): int; // ввод числа от пользователя
+getString(prompt: String, stringPatterns: String[]):String / выбор из списка шаблонов


 */
}
