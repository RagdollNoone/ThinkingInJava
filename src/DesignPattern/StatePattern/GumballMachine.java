package DesignPattern.StatePattern;

public class GumballMachine {
    private HasQuarterState hasQuarterState;
    private NoQuarterState noQuarterState;
    private SoldOutState soldOutState;
    private SoldState soldState;

    private State currentState;
    int count;

    public GumballMachine(int count) {
        hasQuarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);

        currentState = soldOutState;

        this.count = count;
        if (count > 0) {
            currentState = noQuarterState;
        }
    }

    public void insertQuarter() {
        this.currentState.insertQuarter();
    }

    public void ejectQuarter() {
        this.currentState.ejectQuarter();
    }

    public void turnCrank() {
        this.currentState.turnCrank();
        this.currentState.dispense();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        System.out.println("setCurrentState: current state is " + this.currentState.toString());
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public NoQuarterState getNoQuarterState() {
        return noQuarterState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
