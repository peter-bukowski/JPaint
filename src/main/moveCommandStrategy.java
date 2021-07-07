package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class moveCommandStrategy implements commandStrategy{
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand move;

    public moveCommandStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas,IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
         move= new moveCommand(startPoint,endPoint,paintCanvas,appState);
        move.run();
    }
}
