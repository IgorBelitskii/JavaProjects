package tel_ran.net.balancer.commands;

import tel_ran.net.balancer.servers.ServerRepository;

/**
 * Created by Igor on 29.08.2016.
 */
public class UpdateServer extends Command {

    @Override
    public void setArgs(String[] args) {
        if (args.length < 2)
            throw new RuntimeException("Not enough parameters to update tel_ran.net.tcpserver.server information");
        super.setArgs(args);
    }

    @Override
    public Object execCommand() {
        String server = args[0];
        Integer port = Integer.valueOf(args[1]);
        Integer workload = Integer.valueOf(args[2]);
        return ServerRepository.updateServerInfo(server, port, workload);
    }
}
