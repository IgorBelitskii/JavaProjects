import java.io.IOException;
import java.net.*;
public class UDPServer {

	/**
	 * Known to Client ant do TCP Server,
	 * this server accumulate information about TCP Server
	 * and sends it to Client, when Client request this infomation
	 */

	private static final int PORT = 9999;
	private static final int MAX_RECEIVE = 1500;
	
public static void main(String[] args) {
		
		try(DatagramSocket socket=new DatagramSocket(PORT);) {
			
			byte arrayReceive[] = new byte[MAX_RECEIVE];
			byte arraySend[];
			int portTCP = 0;
			String hostName = null;
			DatagramPacket packetReceive = new DatagramPacket(arrayReceive, arrayReceive.length);
			System.out.println("Waiting for TCP Server...");
			System.out.println("Waiting for Client...");
			while(true) {
				socket.receive(packetReceive);
				String str=new String(arrayReceive,0, packetReceive.getLength());
				if (str.equals("Server")) {
					System.out.println("Received request of server name and packet from Client.");
					if (portTCP!=0) arraySend=(hostName+":"+portTCP).getBytes(); 
						else arraySend=("Error").getBytes();
				} else {
					portTCP = Integer.parseInt(str);
					hostName = (packetReceive.getAddress()).getHostAddress();
					System.out.println("TCP Server found");
					System.out.println("Received port number TCP:"+portTCP);
					System.out.println("Received server host name:"+ hostName);
					arraySend=("received").getBytes();
				}

				DatagramPacket packetSend = new DatagramPacket(arraySend, arraySend.length, packetReceive.getAddress(),packetReceive.getPort());
				//setData(arraySend);
				socket.send(packetSend);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
