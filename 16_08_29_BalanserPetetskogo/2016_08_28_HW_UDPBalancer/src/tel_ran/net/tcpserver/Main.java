package tel_ran.net.tcpserver;

import tel_ran.net.tcpserver.udp.UDPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Igor on 29.08.2016.
 */
public class Main {

    public Main() {
        Properties props = new Properties();
        try {
            File f = new File("config.ini");
            props.load(new FileInputStream(new File("config.ini")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't load properties from file config.ini");
            System.exit(-1);
        }
        String udpServerAddress = props.getProperty("udp.address");
        int udpServerPort = Integer.valueOf(props.getProperty("udp.port"));

        Thread udpClient = new UDPClient(udpServerAddress, udpServerPort);
        udpClient.start();
    }

    public static void main(String[] args) {
        new Main();
    }
}
