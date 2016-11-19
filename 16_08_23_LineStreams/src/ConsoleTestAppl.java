import java.io.*;

public class ConsoleTestAppl {

	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("please type two integer numbers sperated by space or press enter (or type \"exit\") to exit");
			String line = console.readLine();
			if(line==null||line.length()==0||"exit".equals(line))
				break;
			String[] strNumbers = line.split(" ");
			if (strNumbers.length!=2) {
				System.out.println("Wrong input format");
				continue;
			}
			try {
				int n1 = Integer.parseInt(strNumbers[0]);
				int n2 = Integer.parseInt(strNumbers[1]);
				System.out.println("result="+(n1+n2));
			} catch (NumberFormatException e) {
				System.out.println("This is not two integer numbers, try again");
				continue;
			}
			
		}
		System.out.println("Bye");
	}
	
}
