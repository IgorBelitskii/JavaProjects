package tel_ran.net.tcpserver.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by Igor on 29.08.2016.
 */
public class TCPClient extends Thread {
    private int num;
    private Socket socket;
    private volatile Workload workload;

    public TCPClient(int clientCounter, Socket socket, Workload workload) {
        this.num = clientCounter;
        this.socket = socket;
        this.workload = workload;
    }

    @Override
    public void run() {
        System.out.println("TCP INFO : Got new client " + num + " from " + socket.getInetAddress());
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream writer    = new PrintStream(socket.getOutputStream());

            while (true) {
                String buf = reader.readLine();
                System.out.println("TCP INFO : Got from clienr " + num + " : " + buf);
                if (buf == null || buf.toLowerCase().equals("exit")) {
                    break;
                }
                String reply = "Server said " + buf;
                writer.println(reply);
                System.out.println("TCP INFO : Send to client " + num + " : " + reply);
            }
            reader.close();
            writer.close();
            workload.value--;
        } catch (IOException e) {
            workload.value--;
            e.printStackTrace();
        }
    }
}
