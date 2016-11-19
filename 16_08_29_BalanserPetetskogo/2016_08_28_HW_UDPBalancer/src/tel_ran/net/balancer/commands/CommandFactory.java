package tel_ran.net.balancer.commands;

import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Igor on 29.08.2016.
 */
public class CommandFactory {

    private static Map<String, Class<? extends Command>> commands = new HashMap<>();

    static {
        commands.put("getfreeserver", GetFreeServer.class);
        commands.put("register", Register.class);
        commands.put("updateserver", UpdateServer.class);
    }

    private CommandFactory() {
    }


    public static Command parseCommand(DatagramPacket inPacket) {
        String str = new String(inPacket.getData(), 0, inPacket.getLength());
        String[] parsed = str.split(" ");

        Class<? extends Command> cmdClass = commands.get(parsed[0].toLowerCase());
        if (cmdClass == null)
            throw new RuntimeException("Unknown command : " + parsed[0]);

        String[] args = new String[parsed.length];
        args[0] = inPacket.getAddress().getHostAddress();

        for (int i = 1; i <parsed.length; i++)
            args[i] = parsed[i];

        try {
            Command command = cmdClass.newInstance();
            command.setArgs(args);
            return command;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
