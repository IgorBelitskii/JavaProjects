package tel_ran.net.balancer.servers;

import java.util.Date;

/**
 * Created by Igor on 29.08.2016.
 */
public class ServerEntry {
    Integer workload = 0;
    String address;
    Integer port = 0;
    Date lastUpdate = new Date();

    /**
     * Getter for property 'workload'.
     *
     * @return Value for property 'workload'.
     */
    public Integer getWorkload() {
        return workload;
    }

    /**
     * Setter for property 'workload'.
     *
     * @param workload Value to set for property 'workload'.
     */
    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    /**
     * Getter for property 'address'.
     *
     * @return Value for property 'address'.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for property 'address'.
     *
     * @param address Value to set for property 'address'.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for property 'port'.
     *
     * @return Value for property 'port'.
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Setter for property 'port'.
     *
     * @param port Value to set for property 'port'.
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * Getter for property 'lastUpdate'.
     *
     * @return Value for property 'lastUpdate'.
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Setter for property 'lastUpdate'.
     *
     * @param lastUpdate Value to set for property 'lastUpdate'.
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return address + ":" + port;
    }
}
