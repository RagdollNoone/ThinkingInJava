package DesignPattern.StatePattern;

public class NoQuarterState implements State {
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("NoQuarterState: insertQuarter success");
        gumballMachine.setCurrentState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("NoQuarterState: ejectQuarter fail");
    }

    @Override
    public void turnCrank() {
        System.out.println("NoQuarterState: turnCrank fail");
    }

    @Override
    public void dispense() {
        System.out.println("NoQuarterState: dispense fail");
    }

    @Override
    public String toString() {
        return "NoQuarterState";
    }
}
