package tel_ran.net.balancer.commands;

import java.util.Arrays;

/**
 * Created by Igor on 29.08.2016.
 */
public abstract class Command {
    protected String[] args;

    public void setArgs(String[] args) {
        this.args = args;
    }

    public abstract Object execCommand();

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+". args : " + this.argsToString();
    }

    protected String argsToString() {
        StringBuilder sb = new StringBuilder();
        for (String s : args) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }
}
