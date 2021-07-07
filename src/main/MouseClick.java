package main;


import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MouseClick extends MouseAdapter  {
    private Point startPoint;
    private Point endPoint;
    private  PaintCanvasBase paintCanvas;
    private ICommand command;
    private IApplicationState appState;

    MouseClick(PaintCanvasBase paintCanvas,IApplicationState appState){
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

      //  System.out.println(e.getX()+","+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

            startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint= new Point(e.getX(),e.getY());
        command= new ShapeCommand(startPoint,endPoint,paintCanvas,appState);
        command.run();


    }


}
