package DesignPattern.CommandPattern;

public interface Command {
    void execute();
    void undo(); // TODO: only can undo recent command action
}
