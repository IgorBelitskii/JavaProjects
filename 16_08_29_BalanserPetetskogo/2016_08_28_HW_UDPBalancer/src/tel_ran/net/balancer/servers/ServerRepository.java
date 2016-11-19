package tel_ran.net.balancer.servers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Igor on 29.08.2016.
 */
public class ServerRepository {
    private static ConcurrentHashMap<String, ServerEntry> servers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, List<ServerEntry>> workloadIndex = new ConcurrentHashMap<>();

    public static boolean registerServer(String address, int port) {
        checkServers();
        String key = getKey(address, port);
        ServerEntry server = servers.get(key);
        if (server == null) {
            server = new ServerEntry();
            server.address = address;
            server.port = port;
        }
        server.lastUpdate = new Date();
        servers.put(key, server);

        addToIndex(server);
        return true;
    }

    public static boolean updateServerInfo(String serverAddress, int port, int workload) {
        checkServers();
        String key = getKey(serverAddress, port);
        ServerEntry server = servers.get(key);
        if (server == null) {
            registerServer(serverAddress, port);
            server = servers.get(key);
        }

        removeFromIndex(server);
        server.workload = workload;
        addToIndex(server);
        return true;
    }

    public static ServerEntry getFreeServer() {
        checkServers();
        if (workloadIndex.keySet().size() == 0 ) return null;
        Integer minWorkload = workloadIndex.keySet().iterator().next();
        if (minWorkload == null) return null;
        List<ServerEntry> list = workloadIndex.get(minWorkload);
        if (list == null || list.size() == 0 ) return null;
        ServerEntry server = list.get(0);

        return server;
    }

    private static String getKey(String address, int port) {
        return address + ":"+port;
    }

    private static void addToIndex(ServerEntry server) {
        if (server == null) return;
        List<ServerEntry> list = workloadIndex.get(server.workload);
        if (list == null) {
            list = new ArrayList<>();
            workloadIndex.put(server.workload, list);
        }
        list.add(server);
    }

    private static void removeFromIndex(ServerEntry server) {
        if (server == null) return;
        List<ServerEntry> list = workloadIndex.get(server.workload);
        list.remove(server);
        if (list.size() == 0) {
            workloadIndex.remove(server.workload);
        }
    }

    private static boolean deleteServer(ServerEntry server) {
        if (server == null) return false;
        String key = getKey(server.address, server.port);
        servers.remove(key);
        removeFromIndex(server);
        return true;
    }

    private static void checkServers() {
        Iterator<ServerEntry> it = servers.values().iterator();
        Date now = new Date();
        while (it.hasNext()) {
            ServerEntry serverEntry = it.next();
            if (now.getTime() - serverEntry.getLastUpdate().getTime() > 60*1000) {
                //Если сервер в течении минуты не обновлял инфу о себе, считаем его недоступным
                deleteServer(serverEntry);
            }
        }
    }
}
