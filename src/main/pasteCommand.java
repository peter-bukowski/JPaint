package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class pasteCommand  implements ICommand, IUndoable {
    private IApplicationState appState;
    private PaintCanvasBase paintCanvas;
    ArrayList<Shape> pastedShape= new ArrayList<Shape>();

    public pasteCommand(IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;

    }

    @Override
    public void run() {
        CommandHistory.add(this);
        for (Shape s : appState.getCopyList()) {
            int x = Math.abs(s.getX() - s.getX1());
            int y = Math.abs(s.getY() - s.getY1());
            if (s.isPolygon()) {
                TriangleShape triangle= new TriangleShape(s.getStartPoint(),s.getEndPoint(),paintCanvas,appState);
                triangle.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                triangle.setShading(s.getShading());
                triangle.setX(s.getX()-30);
                triangle.setY(s.getY()-30);
               triangle.setX1(triangle.getX()+x);
               triangle.setY1( triangle.getY()+y);
                triangle.setNewX();
               triangle.setNewY();
                triangle.drawShape();
                appState.setShapelist(triangle);
                pastedShape.add(triangle);
            }
           if (s.isRectangle()) {
                Shape shape = new RectangleShape(s.getStartPoint(), s.getEndPoint(), paintCanvas, appState);
                shape.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                shape.setShading(s.getShading());
                shape.setX(s.getX()-30);
                shape.setY(s.getY()-30);
                shape.drawShape();
                appState.setShapelist(shape);
                pastedShape.add(shape);
             }
           if(s.isEllipse()){
                Shape ellipse = new EllipseShape(s.getStartPoint(), s.getEndPoint(), paintCanvas, appState);
                ellipse.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                ellipse.setShading(s.getShading());
                ellipse.setX(s.getX()-30);
                ellipse.setY(s.getY()-30);
                ellipse.drawShape();
                appState.setShapelist(ellipse);
               pastedShape.add(ellipse);
           }

        }
    }

    @Override
    public void undo() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shape j: pastedShape){
            appState.getShapelist().remove(j);
        }
        for(Shape s: appState.getShapelist()){
            s.drawShape();
        }

    }

    @Override
    public void redo() {
        run();
    }
}
