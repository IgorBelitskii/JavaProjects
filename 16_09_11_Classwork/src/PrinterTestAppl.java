import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// оформляет консольную аппликацию
/*
 * Если нажимаем на Enter
 * Переводим на следующий символ (интеррапт)
 * 
 * args0 - number of "enters" 
 * args1 = string
 */
public class PrinterTestAppl {

	public static void main(String[] args) throws IOException {

		Printer printer = new Printer();
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		printer.start();
		while(true) {
			String line = console.readLine();
			if (line.equalsIgnoreCase("exit")) {
				printer.interrupt();
				return;
				
			}
		}
		
// как зациклить самого себя без цикла - join
		
	}

}
