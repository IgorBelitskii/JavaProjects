package tel_ran.net.tcpserver.udp;

import tel_ran.net.tcpserver.tcp.TCPServer;

/**
 * Created by Igor on 29.08.2016.
 */
public class UDPClient extends Thread {
    private String address;
    private int port;

    public UDPClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    @Override
    public void run() {

        TCPServer tcpServer = new TCPServer();

        UDPUtils.register(address, port, tcpServer.getPort());
        tcpServer.start();
        while (true) {
            try {
                Thread.sleep(10*1000);
                UDPUtils.sendHeartbit(tcpServer.getWorkload());
            } catch (InterruptedException e) {
            }
        }
    }
}
