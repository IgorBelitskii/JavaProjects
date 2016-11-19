package tel_ran.view;

public interface DataProvider {
	
	void showMessage(String message);
	String getString(String prompt, String stringPatterns[]);
	int getInteger(String prompt, int minValue, int maxValue);
	
/*
 * +showMessage(message: String); // ��������� message � ���������� ���
+getInteger(prompt: String, minValue: int, maxValue:int): int; // ���� ����� �� ������������
+getString(prompt: String, stringPatterns: String[]):String / ����� �� ������ ��������


 */
}
