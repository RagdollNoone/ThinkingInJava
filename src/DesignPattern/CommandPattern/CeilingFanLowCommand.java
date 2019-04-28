package DesignPattern.CommandPattern;

import DesignPattern.CommandPattern.CeilingFan.*;

public class CeilingFanLowCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFanSpeed preSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        preSpeed = ceilingFan.getSpeed();

        System.out.print("CeilingFanLowCommand execute: ");
        ceilingFan.setSpeed(CeilingFanSpeed.LOW);


    }

    @Override
    public void undo() {
        System.out.print("CeilingFanLowCommand undo: ");
        ceilingFan.setSpeed(preSpeed);
    }
}
