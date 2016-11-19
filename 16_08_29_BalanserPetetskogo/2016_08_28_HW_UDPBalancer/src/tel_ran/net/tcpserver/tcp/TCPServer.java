package tel_ran.net.tcpserver.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Igor on 29.08.2016.
 */
public class TCPServer extends Thread {
    private int port;
    private int clientCounter = 0;
    private ServerSocket ssocket;
    private volatile Workload workload = new Workload();

    public int getPort() {
        return port;
    }

    public TCPServer() {
        try {
            ssocket = new ServerSocket(0);
            this.port = ssocket.getLocalPort();
        } catch (IOException e) {
            System.out.println("TCP SEVERE : Can't start TCP server.");
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = ssocket.accept();
                clientCounter++;
                workload.value++;
                Thread client = new TCPClient(clientCounter, socket, workload);
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWorkload() {
        return workload.value;
    }
}
