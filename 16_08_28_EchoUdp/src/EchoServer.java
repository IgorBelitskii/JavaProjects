import java.io.IOException;
import java.net.*;
public class EchoServer {


	private static final int PORT = 5776;
	private static final int MAX_RECEIVE = 1500;

	public static void main(String[] args){
		
		try(DatagramSocket socket=new DatagramSocket(PORT);) {
			
			byte arrayReceive[] = new byte[MAX_RECEIVE];
			byte arraySend[];
			DatagramPacket packetReceive = new DatagramPacket(arrayReceive, arrayReceive.length);
			
			while(true) {
				
				socket.receive(packetReceive);
				String str=new String(arrayReceive,0, packetReceive.getLength());
				arraySend=(str+" from Server").getBytes();
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
