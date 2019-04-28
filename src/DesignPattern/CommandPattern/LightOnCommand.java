package DesignPattern.CommandPattern;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.print("LightOnCommand execute: ");
        light.on();
    }

    @Override
    public void undo() {
        System.out.print("LightOnCommand undo: ");
        light.off();
    }
}
