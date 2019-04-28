package DesignPattern.CommandPattern;

import DesignPattern.CommandPattern.CeilingFan.*;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFanSpeed preSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        preSpeed = ceilingFan.getSpeed();
        System.out.print("CeilingFanOffCommand execute: ");
        ceilingFan.setSpeed(CeilingFanSpeed.OFF);
    }

    @Override
    public void undo() {
        System.out.print("CeilingFanOffCommand undo: ");
        ceilingFan.setSpeed(preSpeed);
    }
}
