package tel_ran.net.balancer.commands;

import tel_ran.net.balancer.servers.ServerRepository;

/**
 * Created by Igor on 29.08.2016.
 */
public class GetFreeServer extends Command {

    @Override
    public Object execCommand() {
       return ServerRepository.getFreeServer();
    }
}
