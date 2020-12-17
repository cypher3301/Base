package study.inheritens.abstract_class_hierarchy;

public class Ball extends SolidOfRevolation{



    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVelome() {
        return Math.PI * Math.pow(radius, 3) * 4 / 3;
    }
}