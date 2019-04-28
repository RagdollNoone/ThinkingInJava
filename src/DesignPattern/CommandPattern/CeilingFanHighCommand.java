package DesignPattern.CommandPattern;

import DesignPattern.CommandPattern.CeilingFan.*;

public class CeilingFanHighCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFanSpeed preSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        preSpeed = ceilingFan.getSpeed();

        System.out.print("CeilingFanHighCommand execute: ");
        ceilingFan.setSpeed(CeilingFanSpeed.HIGH);
    }

    @Override
    public void undo() {
        System.out.print("CeilingFanHighCommand undo: ");
        ceilingFan.setSpeed(preSpeed);
    }
}
