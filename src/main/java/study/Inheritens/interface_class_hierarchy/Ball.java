package study.Inheritens.interface_class_hierarchy;

public class Ball extends SolidOfRevolution {
    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVelume() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }
}
