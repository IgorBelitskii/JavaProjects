import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;


// Ќаписать протокл калькул€тор 
/*
 * —ервер получает запрос
 * операци€ и два операнда
 * нпример + 2 3
 * результат 5
 * 
 * релизовать 4 операции с условием использовать только один if и  (можно еще один дл€ readline
 * не использовать много классов
 * 
 * —ервер обрабатывает клиентский запрос
 * 
 */
public class EchoClient {

	private static final int PORT = 8888;

	public static void main(String[] args) throws UnknownHostException, IOException {

		try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
				Socket socket = new Socket("localhost", PORT);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream writer = new PrintStream(socket.getOutputStream());
				) {
			
			while(true) {
				System.out.println("Enter operation and two operands or exit");
				String line = console.readLine();
				writer.println(line);
				String rline=reader.readLine();
				if ((line==null) || line.equals("exit")) break;
				System.out.println(rline);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println("Bye");
	}

}
