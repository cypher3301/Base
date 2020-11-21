package study.Inheritens.shape_class_hierarchy;

public class Ball extends SolidOfRevolation {

    public Ball(double radius) {
        super(Math.PI * Math.pow(radius, 3) * 4 / 3,radius);
    }
}