package tel_ran.net.balancer;

import tel_ran.net.balancer.commands.Command;
import tel_ran.net.balancer.commands.CommandFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Igor on 29.08.2016.
 */
public class Main {
    private static int udpPort = 9999;
    private static int BUF_SIZE = 1432;
    private static byte[] buf = new byte[BUF_SIZE];

    public static void main(String[] args) {
        init(args);
        System.out.println("INFO : UDP balancer try to start at port " + udpPort);
        try (DatagramSocket udpSocket = new DatagramSocket(udpPort)){
            System.out.println("INFO : UDP Balancer started at port " + udpPort);
            while (true) {
                DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
                try {
                    udpSocket.receive(inPacket);
                } catch (IOException e) {
                    System.out.println("ERR : got error while receiving packet from " + inPacket.getAddress());
                    continue;
                }
                String res;
                try {
                    Command command = CommandFactory.parseCommand(inPacket);
                    System.out.println("INFO : Got command " + command.toString() + " from " + inPacket.getAddress() + ":" + inPacket.getPort());
                    Object r = command.execCommand();
                    if (r != null)
                        res = r.toString();
                    else
                        res = "null";
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    String err = e.getMessage();
                    System.out.println("ERROR : " + err);
                    res = err.substring(0, (500 < err.length() ? 500 : err.length()));
                }

                sendReply(inPacket, res);
            }
        } catch (SocketException e) {
            System.out.println("SEVERE : Failed to start at port " + udpPort);
        }
    }

    private static void sendReply(DatagramPacket packet, String text) throws SocketException {
        DatagramPacket outPacket = new DatagramPacket(text.getBytes(), text.length());
        outPacket.setPort(packet.getPort());
        outPacket.setAddress(packet.getAddress());
        DatagramSocket outSocket = new DatagramSocket();
        outSocket.setSoTimeout(500);
        try {
            outSocket.send(outPacket);
            System.out.println("INFO : Send reply " + text + " to " + packet.getAddress() + ":" + packet.getPort());
        } catch (IOException e) {
            System.out.println("ERR : Failed to send reply to " + outSocket.getInetAddress());
        }
    }

    private static void init(String[] args) {
        if (args.length != 1) {
            showHelp();
            System.exit(-1);
        }

        try {
            udpPort = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            showHelp();
            System.exit(-1);
        }
    }

    private static void showHelp() {
        System.out.println("Usage : ");
        System.out.println("    udp_balancer <port>");

    }
}
