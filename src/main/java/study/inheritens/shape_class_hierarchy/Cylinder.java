package study.inheritens.shape_class_hierarchy;

public class Cylinder extends SolidOfRevolation {
    private final double haight;

    public Cylinder(double radius, double haight) {
        super(Math.PI * radius * radius * haight, radius);
        this.haight=haight;
    }
}
