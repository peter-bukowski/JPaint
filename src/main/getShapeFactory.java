package main;

import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

class getShapeFactory {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;


    public void getShape(IApplicationState appState, Point startPoint, Point endPoint, PaintCanvasBase paintCanvas) {
        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
            Shape shep = new RectangleShape(startPoint, endPoint, paintCanvas, appState);
            shep.drawShape();
            appState.setShapelist(shep);

        }
        if (appState.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
            Shape ellipse = new EllipseShape(startPoint, endPoint, paintCanvas, appState);
            ellipse.drawShape();
            appState.setShapelist(ellipse);

        }
        if (appState.getActiveShapeType().equals(ShapeType.TRIANGLE)) {
            Shape tri = new TriangleShape(startPoint, endPoint, paintCanvas, appState);
            tri.drawShape();
            appState.setShapelist(tri);

        }

    }

}
