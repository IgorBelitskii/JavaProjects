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
	private static final int PORT = 5776;

	public static void main(String[] args) throws IOException {
		BufferedReader console= 
				new BufferedReader(new InputStreamReader(System.in));
		byte arrayReceive[]= new byte[1500];
		DatagramPacket packetReceive = new DatagramPacket(arrayReceive, arrayReceive.length);
		try (DatagramSocket socket = new DatagramSocket()) {
			socket.setSoTimeout(TIMEOUT);
			while (true) {
				System.out.println("Enter any string");
				String line = console.readLine();
				if (line==null || line.equals("exit"))
				 break;
				byte[] arraySend=line.getBytes();
				DatagramPacket packetSend = new DatagramPacket(arraySend,  arraySend.length, InetAddress.getByName(HOST), PORT);
				
				while (true) {
					try {
						socket.send(packetSend);
						socket.receive(packetReceive);
						System.out.println(new String(arrayReceive,0,packetReceive.getLength()));
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
	}

}
