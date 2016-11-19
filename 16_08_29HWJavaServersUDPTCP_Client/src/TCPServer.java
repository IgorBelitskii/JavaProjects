import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;


public class TCPServer {
	private static final String HOST = "localhost";
	private static final int PORT = 9999;
	private static final int TIMEOUT = 100;


	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(0);  // setting random free port
		int localPort=serverSocket.getLocalPort();
		System.out.println(localPort); // 
		String answer;
		// Connecting to UDP server and sending port
		byte arrayReceive[]= new byte[1500];
		DatagramPacket packetReceive = new DatagramPacket(arrayReceive, arrayReceive.length);
		try (DatagramSocket socket = new DatagramSocket()) {
			socket.setSoTimeout(100);
			while (true) {
				String line=String.valueOf(localPort);
				byte[] arraySend=line.getBytes();
				DatagramPacket packetSend = new DatagramPacket(arraySend,  arraySend.length, InetAddress.getByName(HOST), PORT);	
				while (true) {
					try {
						socket.send(packetSend);
						socket.receive(packetReceive);
						answer=new String(arrayReceive,0,packetReceive.getLength());
						System.out.println(answer);
						break;
					} catch (IOException e) {
						System.out.println("time out " + TIMEOUT);
					} 
				}
				if (answer.equals("received")) break;
			}
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Port number sended.");
		System.out.println("Waiting for client...");
		// 	waiting for client
		while(true) {
			Socket socket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream writer = new PrintStream(socket.getOutputStream());
			while(true) {
			try {
				String line = reader.readLine();
				if (line==null) 
						break;
				writer.println("Well done! \""+line+ "\" received by TCP Server");
			} catch (Throwable e) {
				writer.println("Invalid request");
			}	
			
			}
		} 

	}

}
