//package DesignPattern.ProxyPattern;

public class SoldOutState implements State {
    private static final long serialVersionUID = 1L;
    transient private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SoldOutState: insertQuarter fail");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SoldOutState: ejectQuarter fail");
    }

    @Override
    public void turnCrank() {
        System.out.println("SoldOutState: turnCrank fail");
    }

    @Override
    public void dispense() {
        System.out.println("SoldOutState: dispense fail");
    }

    @Override
    public String toString() {
        return "SoldOutState";
    }
}
