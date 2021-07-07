package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class selectCommandStrategy implements commandStrategy {

    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand select;

    public selectCommandStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas,IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
        select= new selectCommand(startPoint,endPoint,paintCanvas,appState);
        select.run();
    }
}
