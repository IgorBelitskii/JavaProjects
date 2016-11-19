package tel_ran.net.balancer.commands;

import tel_ran.net.balancer.servers.ServerRepository;

/**
 * Created by Igor on 29.08.2016.
 */
public class Register extends Command {

    @Override
    public void setArgs(String[] args) {
        if (args.length < 2)
            throw new RuntimeException("Not enough parameters to register tel_ran.net.tcpserver.server");
        super.setArgs(args);
    }

    @Override
    public Object execCommand() {
        String serverAddress = args[0];
        Integer serverPort = Integer.valueOf(args[1]);
        return ServerRepository.registerServer(serverAddress, serverPort);
    }
}
