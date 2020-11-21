package study.Inheritens.interface_class_hierarchy;

import java.util.ArrayList;

public class Box implements Shape {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private double volume;
    private double available;

    public Box(double available) {
        this.volume = available;
        this.available=available;
    }

    public boolean add(Shape shape){
        if(available>=shape.getVelume()){
            shapes.add(shape);
            available-=shape.getVelume();
            return true;
        }
        return false;
    }

    @Override
    public double getVelume() {
        return volume;
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
