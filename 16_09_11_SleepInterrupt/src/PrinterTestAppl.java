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

		int numThreads = Integer.parseInt(args[0]);
		Printer[] printers = new Printer[numThreads];
		for (int i = 0; i < numThreads; i++) {
			printers[0] = new Printer(i);
		}
		
// как зациклить самого себя без цикла - join
		
	}

}
