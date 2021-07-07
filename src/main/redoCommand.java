package main;

public class redoCommand implements ICommand {

    @Override
    public void run() {
        CommandHistory.redo();
    }
}
