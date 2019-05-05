package DesignPattern.ProxyPattern;

public class SoldState implements State {
    private static final long serialVersionUID = 1L;
    transient private GumballMachine gumballMachine;

    public SoldState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SoldState: insertQuarter fail");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SoldState: ejectQuarter fail");
    }

    @Override
    public void turnCrank() {
        System.out.println("SoldState: turnCrank fail");
    }

    @Override
    public void dispense() {
        System.out.println("SoldState: dispense success");
        int count = gumballMachine.getCount() - 1;
        gumballMachine.setCount(count);
        if (count > 0) {
            gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());

        } else {
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "SoldState";
    }
}
