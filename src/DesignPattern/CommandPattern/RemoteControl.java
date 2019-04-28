package DesignPattern.CommandPattern;

public class RemoteControl {
    private Command[] commandOn;
    private Command[] commandOff;
    private Command preCommand;

    static private byte slotNumber = 7;

    public RemoteControl() {
        commandOn = new Command[slotNumber];
        commandOff = new Command[slotNumber];
    }

    public void setCommand(byte slot, Command commandOn, Command commandOff) {
        this.commandOn[slot] = commandOn;
        this.commandOff[slot] = commandOff;
    }

    public void pressOn(byte slot) {
        commandOn[slot].execute();
        preCommand = commandOn[slot];
    }

    public void pressOff(byte slot) {
        commandOff[slot].execute();
        preCommand = commandOff[slot];
    }

    public void pressUndo() {
        preCommand.undo();
    }
}
