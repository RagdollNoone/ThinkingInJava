package DesignPattern.CommandPattern;

public class CommandPattern {
    public static void TestCommandPattern(String[] args) {
        System.out.println("Test CommandPattern Result: ");

        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        CeilingFan ceilingFan = new CeilingFan();

        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        Command ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
        Command ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);

        Command[] commandsOn = {lightOnCommand, ceilingFanLowCommand, ceilingFanMediumCommand, ceilingFanHighCommand};
        Command[] commandsOff = {ceilingFanMediumCommand, ceilingFanLowCommand, ceilingFanOffCommand, lightOffCommand};

        Command macroCommandOn = new MacroCommand(commandsOn);
        Command macroCommandOff = new MacroCommand(commandsOff);

        remoteControl.setCommand((byte)0, macroCommandOn, macroCommandOff);

        remoteControl.pressOn((byte)0);
        remoteControl.pressUndo();
        remoteControl.pressOn((byte)0);
        remoteControl.pressOff((byte)0);
        remoteControl.pressUndo();

        System.out.println("############### END ###############");
        System.out.println();
    }
}
