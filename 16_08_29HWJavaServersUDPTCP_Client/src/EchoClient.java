import java.net.*;
import java.io.*;
public class EchoClient {
	// ����� ��������:
	// ���������� ����������� ����� ������� � ������� UDP
	// ����� ��������� ������ ������� TCP �������� ������ TCP
	// �������� ����� �� TCP

	
	// �������� �������
	// 1 ������ TCP 1 ������ UDP
	// 1 TCP � UDP Client
	
	/* 
	 * ������ ����� UDP �� �� ����� TCP
	 * 
	 *  * TCP ������ ���� UDP ������� ���� hostname � ���� ����
	 * TCP ����� ������� ������ ����, �.�. ����� ����� ����� �� Datagram, .get Inetadress;
	 * 
	 * �� �������� �� ������ TCP �� �� �����
	 * �� �������� ������ UDP �������� ����� � ���� TCP
	 * �������� ������ TCP � �������� �����
	 * 
	 */
	
	private static final int TIMEOUT = 100;
	private static final String HOST = "localhost";
	private static final int PORT = 9999;

	public static void main(String[] args) throws IOException {
		String serverName = null;
		int serverPort = 0;
		String answer;
		byte arrayReceive[]= new byte[1500];
		DatagramPacket packetReceive = new DatagramPacket(arrayReceive, arrayReceive.length);
		try (DatagramSocket socket = new DatagramSocket()) {
			socket.setSoTimeout(TIMEOUT);
			while (serverPort==0) {
				byte[] arraySend="Server".getBytes();
				DatagramPacket packetSend = new DatagramPacket(arraySend,  arraySend.length, InetAddress.getByName(HOST), PORT);
				
				while (true) {
					try {
						socket.send(packetSend);
						socket.receive(packetReceive);
						answer=new String(arrayReceive,0,packetReceive.getLength());
						System.out.println(answer);
						String[] server = answer.split(":");
						serverName=server[0];
						serverPort=Integer.parseInt(server[1]);
						System.out.println("Received server name:"+serverName);
						System.out.println("Received server port:"+serverPort);
						break;
					} catch (IOException e) {
						System.out.println("time out " + TIMEOUT);
					} 
				}
			}
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connecting to TCP Server...");
		
		try(BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
				Socket socket = new Socket(serverName, serverPort);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintStream writer = new PrintStream(socket.getOutputStream());
			
				) {
			
			while(true) {
				
				System.out.println("Enter command to the TCP server, or type \"exit\":");
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
