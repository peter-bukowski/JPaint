package main;

import javafx.scene.paint.Color;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class copyCommand implements ICommand, IUndoable {
    private IApplicationState appState;


    public copyCommand(IApplicationState appState) {
        this.appState = appState;
    }

    @Override
    public void run() {
        CommandHistory.add(this);
        for (Shape s : appState.getShapelist()) {
            if (s.isSelected == true) {
                appState.setCopylist(s);
            }
        }

    }

    @Override
    public void undo() {
        System.out.println("copyCommand");

    }

    @Override
    public void redo() {

    }
}
