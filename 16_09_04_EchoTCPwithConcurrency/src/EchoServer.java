import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.HashMap;


public class EchoServer {

	private static final int PORT = 8888;
	

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(0);
		System.out.println(serverSocket.getLocalPort());
		serverSocket=new ServerSocket(PORT);
		while(true) {
			Socket socket = serverSocket.accept();
			System.out.println("Client connected: "+socket.getLocalAddress());
			Connection con = new Connection(socket);
			Thread tr= new Thread(con);
			tr.start();
			
		} 

	}

}
