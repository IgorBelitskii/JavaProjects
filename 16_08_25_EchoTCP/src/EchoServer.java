import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.HashMap;


public class EchoServer {

	private static final int PORT = 8888;
	private static HashMap<String, Operation> map = new HashMap<>();
	static {
		map.put("+", (c,d)-> c+d);
		map.put("-", (c,d)-> c-d);
		map.put("*", (c,d)-> c*d);
		map.put("/", (c,d)-> c==0? 0: c/d);	
	}

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(0);
		System.out.println(serverSocket.getLocalPort());
		serverSocket=new ServerSocket(PORT);
		while(true) {
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream writer = new PrintStream(socket.getOutputStream());
			while(true) {
			String line = reader.readLine();
			if (line==null) 
					break;
			
			String[] array = line.split(" ");
			String operand="";
			double a=0,b=0;
			try {
				operand=array[0];
				a=Double.parseDouble(array[1]);
				b=Double.parseDouble(array[2]);
				double result=map.get(operand).Operate(a, b);
				writer.println("Answer: "+result);
			} catch (Throwable e) {
				writer.println("Invalid request");
			}	
			
			}
		} 

	}

}
