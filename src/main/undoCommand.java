package main;

public class undoCommand implements ICommand{
    @Override
    public void run() {
        CommandHistory.undo();
    }
}
