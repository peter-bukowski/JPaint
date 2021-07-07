package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class deleteCommand implements ICommand, IUndoable {
    private IApplicationState appState;
    private PaintCanvasBase paintCanvas;
    ArrayList<Shape> deletedShape= new ArrayList<Shape>();
    ArrayList<Shape> redo= new ArrayList<Shape>();

    public deleteCommand(IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas=paintCanvas;
    }

    @Override
    public void run() {
        CommandHistory.add(this);
        for (Shape s : appState.getShapelist()) {
            if (s.isSelected) {
                s.clearShape();
                deletedShape.add(s);
                appState.getShapelist().remove(s);

            }
        }
    }


    @Override
    public void undo() {


        for(int i=deletedShape.size()-1;i>=0;i++){
            deletedShape.get(i).drawShape();
            deletedShape.get(i).selectShape();
            appState.setShapelist(deletedShape.get(i));
            redo.add(deletedShape.get(i));
            deletedShape.remove(deletedShape.get(i));
        }


    }

    @Override
    public void redo() {

        for(int i=redo.size()-1;i>=0;i++){
            redo.get(i).clearShape();
            redo.remove(redo.get(i));
            deletedShape.add(redo.get(i));
            appState.getShapelist().remove(redo.get(i));
        }


    }
}

