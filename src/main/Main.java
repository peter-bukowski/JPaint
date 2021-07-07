package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.EnumMap;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        Shape groupedShape= new groupedShape();
        ICommand delete= new deleteCommand(appState,paintCanvas);
        ICommand paste= new pasteCommand(appState,paintCanvas);
        ICommand copy= new copyCommand(appState);
        ICommand group= new groupCommand(appState,groupedShape);
        ICommand ungroup= new unGroup(appState,groupedShape);
        IJPaintController controller = new JPaintController(uiModule, appState,copy,paste,delete,group,ungroup);
        controller.setup();
        paintCanvas.addMouseListener(new MouseClick(paintCanvas,appState));









        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
