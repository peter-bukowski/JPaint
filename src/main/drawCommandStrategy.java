package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class drawCommandStrategy implements commandStrategy {

    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand draw;
    public drawCommandStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas,IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
        draw= new drawCommand(startPoint,endPoint,paintCanvas,appState);
        draw.run();
    }
}
