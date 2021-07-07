package main;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShapeCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;

    public ShapeCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas,IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void run() {

        if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
            commandStrategy draw= new drawCommandStrategy(startPoint,endPoint,paintCanvas,appState);
            draw.executeCommand();
        }
       if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)){
           commandStrategy select= new selectCommandStrategy(startPoint,endPoint,paintCanvas,appState);
           select.executeCommand();
       }
        if(appState.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.MOVE)){
            commandStrategy move= new moveCommandStrategy(startPoint,endPoint,paintCanvas,appState);
            move.executeCommand();

        }





    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}



