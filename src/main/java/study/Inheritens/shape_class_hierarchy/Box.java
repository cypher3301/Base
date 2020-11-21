package study.Inheritens.shape_class_hierarchy;

import java.util.ArrayList;

public class Box extends Shape {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private double volume;
    private double available;

    public Box(double available) {
        super(available);
        this.available=available;
    }

    public boolean add(Shape shape){
        if(available>=shape.getVelome()){
            shapes.add(shape);
            available-=shape.getVelome();
            return true;
        }
        return false;
    }

    @Override
    public double getVelome() {
        return volume;
    }
}
