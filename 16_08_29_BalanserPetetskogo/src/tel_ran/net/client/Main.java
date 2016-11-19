package tel_ran.net.client;

import java.io.*;
import java.net.*;
import java.util.Properties;

/**
 * Created by Igor on 29.08.2016.
 */
public class Main {
    private String udpAddress;
    private int udpPort;
    private String tcpAddress;
    private int tcpPort;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        init();
        getTcpServerInfo();
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("TCP INFO : Try to connect tcp server " + tcpAddress+":"+tcpPort);
            Socket socket = new Socket(tcpAddress, tcpPort);
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("TCP INFO : Connected to tcp server " + tcpAddress+":"+tcpPort);
            while (true) {
                System.out.print("====>");
                String line = console.readLine();
                if (line == null || line.equals("exit")) {
                    console.close();
                    in.close();
                    out.close();
                    socket.close();
                    break;
                }
                System.out.println("TCP INFO : Send to tcp server message " + line);
                out.println(line);
                String response = in.readLine();
                if (response == null) {
                    System.out.println("TCP INFO : End of communication channel");
                    break;
                }
                System.out.println("TCP INFO : Got from tcp server : " + response);
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("TCP SEVERE : Can't create tcp socket for " + tcpAddress + ":" + tcpPort);
            System.exit(-1);
        }
    }

    private void getTcpServerInfo() {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(1000);

            String command = "GetFreeServer";
            DatagramPacket outPacket = new DatagramPacket(command.getBytes(), command.length());
            outPacket.setAddress(InetAddress.getByName(udpAddress));
            outPacket.setPort(udpPort);
            socket.send(outPacket);
            System.out.println("UDP INFO : Sent to balancer at " + udpAddress + ":" + udpPort + " message " + command);

            byte[] buf = new byte[1432];
            DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
            socket.receive(inPacket);
            String response = new String(inPacket.getData(), 0, inPacket.getLength());
            if (response==null || response.equals("null")) {
                System.out.println("UDP INFO : Balancer haven't free servers.");
                System.exit(-1);
            }
            System.out.println("UDP INFO : Got from balancer " + response);
            String[] parts = response.split(":");
            tcpAddress = parts[0];
            tcpPort = Integer.valueOf(parts[1]);
        } catch (SocketException e) {
            System.out.println("UDP SEVERE : Can't create udp socket");
            System.exit(-1);
        } catch (UnknownHostException e) {
            System.out.println("UDP SEVERE : Can't resolve balancer address : " + udpAddress);
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("UDP ERROR : Can't send packet to balancer");
            System.exit(-1);
        }
    }

    private void init() {
        Properties props = new Properties();
        try {
            File f = new File("config.ini");
            props.load(new FileInputStream(new File("config.ini")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't load properties from file config.ini");
            System.exit(-1);
        }
        udpAddress = props.getProperty("udp.address");
        udpPort = Integer.valueOf(props.getProperty("udp.port"));
    }


}
