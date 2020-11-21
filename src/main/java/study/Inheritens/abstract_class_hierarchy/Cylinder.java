package study.Inheritens.abstract_class_hierarchy;

public class Cylinder extends SolidOfRevolation{
    private double haight;

    public Cylinder(double radius, double haight) {
        super(radius);
        this.haight=haight;
    }

    @Override
    public double getVelome() {
        return Math.PI * radius * radius * haight;
    }
}
