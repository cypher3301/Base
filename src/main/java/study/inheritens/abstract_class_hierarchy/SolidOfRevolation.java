package study.inheritens.abstract_class_hierarchy;

public abstract class SolidOfRevolation extends Shape{
    protected final double radius;

    public SolidOfRevolation(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
