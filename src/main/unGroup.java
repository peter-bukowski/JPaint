package main;

import model.interfaces.IApplicationState;

import java.util.ArrayList;

public class unGroup implements ICommand,IUndoable {
    private IApplicationState appState;
    private int Id=15;
    public static ArrayList<Shape> undo = new ArrayList<>();
    public static ArrayList<Shape> redo = new ArrayList<>();
    private Shape groupedShape;

    public unGroup(IApplicationState appState, Shape groupedShape) {
        this.appState = appState;
        this.groupedShape=groupedShape;
    }

    @Override
    public void run() {
        CommandHistory.add(this);
        //undo.clear();
        for (int i = 0; i < groupedShape.getGroup().size(); i++){
            for(int j=0; j< groupedShape.getGroupList(i).size();j++){
                if(groupedShape.getGroupList(i).get(j).isSelected){
                    groupedShape.getGroupList(i).get(j).setGroupID(-10);
                    undo.add(groupedShape.getGroupList(i).get(j));
                }
            }
        }
    }

    @Override
    public void undo() {
    for(Shape s: undo){
        s.setGroupID(Id);
        redo.add(s);
    }
    Id++;
    undo.clear();
    System.out.println(Id);
    }

    @Override
    public void redo() {
       for(Shape j: redo){
           j.setGroupID(-10);
           undo.add(j);
       }
       redo.clear();
    }
}
