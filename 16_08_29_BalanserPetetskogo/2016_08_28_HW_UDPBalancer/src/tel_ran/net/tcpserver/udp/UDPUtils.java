package tel_ran.net.tcpserver.udp;

import java.io.IOException;
import java.net.*;

/**
 * Created by Igor on 29.08.2016.
 */
public class UDPUtils {
    static volatile String address;
    static volatile int udpPort;
    static volatile int tcpPort;

    public static void register(String add, int udp, int tcp) {
        address = add;
        udpPort = udp;
        tcpPort = tcp;
        System.out.println("UDP INFO : try to register in balancer at " + add + ":" + udp);
        String command = "Register " + tcp;
        try {
            DatagramSocket outSocket = new DatagramSocket();
            sendMessage(outSocket, add, udp, command);
            processReply(outSocket);
        } catch (UnknownHostException e) {
            System.out.println("UDP SEVERE : Can't resolve balancer address : " + add);
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("UDP SEVERE : Can't register in balancer at address : " + add + ":" + udp);
            System.exit(-1);
        }
    }

    private static String getReply(DatagramSocket socket) throws IOException {
        byte[] buf = new byte[1432];
        DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
        socket.receive(inPacket);
        String res = new String(buf, 0, inPacket.getLength());
        return res;
    }

    private static void sendMessage(DatagramSocket socket, String address, int port, String message) throws IOException {
        DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length());
        outPacket.setAddress(InetAddress.getByName(address));
        outPacket.setPort(port);
        socket.setSoTimeout(500);
        socket.send(outPacket);
    }

    public static void sendHeartbit(int workload) {
        System.out.println("UDP INFO : try to send heartbit to balancer at " + address + ":"+ udpPort);
        String command = "UpdateServer " + tcpPort + " " + workload;
        try {
            DatagramSocket outSocket = new DatagramSocket();
            sendMessage(outSocket, address, udpPort, command);
            processReply(outSocket);
        } catch (UnknownHostException e) {
            System.out.println("UDP SEVERE : Can't resolve balancer address : " + address);
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("UDP SEVERE : Can't send heartbit to balancer at address : " + address + ":" + udpPort);
            System.exit(-1);
        }
    }

    private static void processReply(DatagramSocket outSocket) throws IOException {
        String res = getReply(outSocket);

        System.out.println("UDP INFO : got from balancer " + res);
        if (!"true".equals(res)) {
            System.out.println("UDP ERROR : Can't register in balancer.");
            System.out.println("Message : " + res);
            System.exit(-1);
        }
    }
}
