package DesignPattern.CommandPattern;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.print("LightOffCommand execute: ");
        light.off();
    }

    @Override
    public void undo() {
        System.out.print("LightOffCommand undo: ");
        light.on();
    }
}
