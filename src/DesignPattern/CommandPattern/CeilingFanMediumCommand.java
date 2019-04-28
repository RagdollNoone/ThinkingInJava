package DesignPattern.CommandPattern;

import DesignPattern.CommandPattern.CeilingFan.*;

public class CeilingFanMediumCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFanSpeed preSpeed;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        preSpeed = ceilingFan.getSpeed();
        System.out.print("CeilingFanMediumCommand execute: ");
        ceilingFan.setSpeed(CeilingFanSpeed.MEDIUM);
    }

    @Override
    public void undo() {
        System.out.print("CeilingFanMediumCommand undo: ");
        ceilingFan.setSpeed(preSpeed);
    }
}
