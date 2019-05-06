//package DesignPattern.ProxyPattern;

public class HasQuarterState implements State {
    private static final long serialVersionUID = 1L;
    transient private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("HasQuarterState: insertQuarter fail");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("HasQuarterState: ejectQuarter success");
        gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("HasQuarterState: turnCrank success");
        gumballMachine.setCurrentState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("HasQuarterState: dispense fail");
    }

    @Override
    public String toString() {
        return "HasQuarterState";
    }
}
