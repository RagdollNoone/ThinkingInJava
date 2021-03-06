//package DesignPattern.ProxyPattern.RemoteProxy;

import java.rmi.Naming;

public class Client {
    static public void main(String args[]) {
        String[] location = {   "rmi://localhost/a/gumballmachine",
                                "rmi://localhost/b/gumballmachine",
                                "rmi://localhost/c/gumballmachine"
                            };

        GumballMachineMonitor[] monitors = new GumballMachineMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machineRemote = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i] = new GumballMachineMonitor(machineRemote);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitors.length; i++) {
            monitors[i].report();
        }
    }
}
