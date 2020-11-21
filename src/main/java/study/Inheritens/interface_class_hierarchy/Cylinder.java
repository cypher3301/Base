package study.Inheritens.interface_class_hierarchy;


public class Cylinder extends SolidOfRevolution{
    private final double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double getVelume() {
        return Math.PI * radius * radius * height;
    }
}
