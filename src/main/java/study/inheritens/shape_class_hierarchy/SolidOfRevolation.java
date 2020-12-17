package study.inheritens.shape_class_hierarchy;

public class SolidOfRevolation extends Shape {
    protected final double radius;

    public SolidOfRevolation(double volume,double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
