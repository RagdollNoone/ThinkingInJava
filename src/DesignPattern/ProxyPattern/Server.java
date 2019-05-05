package DesignPattern.ProxyPattern;

import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        GumballMachineRemote machineRemote = null;
        int count;

        if (args.length < 2) {
            System.out.println("Gumball Machine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            machineRemote = new GumballMachine(args[0], count);

            Naming.rebind("//" + args[0] + "/gumballmachine", machineRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
