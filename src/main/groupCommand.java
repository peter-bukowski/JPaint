package main;

import model.interfaces.IApplicationState;

import java.util.ArrayList;

public class groupCommand implements ICommand,IUndoable{
    private IApplicationState appState;
    private int groupNum=0;
    private Shape groupedShape;


    public groupCommand(IApplicationState appState,Shape groupShape){
    this.appState=appState;
    this.groupedShape=groupShape;
}
    @Override
    public void run() {
        CommandHistory.add(this);
       for(Shape s: appState.getShapelist()) {
           if (s.isSelected) {
               groupedShape.setShapeList(s);
               s.setGroupID(groupNum);
               groupedShape.setGroupList(groupedShape.getShapeList());
           }

       }
       groupNum++;

    }

    @Override
    public void undo() {
      for(Shape s: groupedShape.getGroupList(groupNum-1)){
          if(s.groupID()==groupNum-1) {
              s.setGroupID(-10);
          }
      }
       groupNum--;

    }

    @Override
    public void redo() {
        System.out.println(groupNum);
        for(Shape s: groupedShape.getGroupList(groupNum)){
            if(s.groupID()!= groupNum)
            s.setGroupID(groupNum);
        }
        groupNum++;
    }
}

/*
int original=groupedShape.getGroupList().size()-1;
        for(int i=groupedShape.getGroupList().size()-1;i>=0;i--){
            if(original > i)break;
            for( int j=groupedShape.getGroupList().get(i).size()-1;j>=0;j--){
                groupedShape.getGroupList().get(i).get(j).setGroupID(-10);

            }

        }
 */