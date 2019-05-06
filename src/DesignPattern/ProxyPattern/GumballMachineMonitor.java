//package DesignPattern.ProxyPattern;

import java.rmi.RemoteException;

public class GumballMachineMonitor {
    GumballMachineRemote machineRemote;

    public GumballMachineMonitor(GumballMachineRemote machineRemote) {
        this.machineRemote = machineRemote;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machineRemote.getLocation());
            System.out.println("Current State: " + machineRemote.getState());
            System.out.println("Gumball Count: " + machineRemote.getCount());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
