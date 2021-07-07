package main;

import java.util.ArrayList;

public class groupedShape extends Shape{
   private  ArrayList<Shape> shapeList = new ArrayList<>();
    private ArrayList<ArrayList<Shape>> groupList= new ArrayList<>();

   public  void setShapeList(Shape shape){
       shapeList.add(shape);
   }
   public  ArrayList<Shape> getShapeList(){
       return shapeList;
   }
   public  void setGroupList(ArrayList<Shape> shape){
       groupList.add(shape);
   }
    public  ArrayList<Shape> getGroupList(int index) {
        ArrayList<Shape> Group=groupList.get(index);
        return Group;
    }

    public ArrayList<ArrayList<Shape>> getGroup(){
       return groupList;
    }
}


