package study.inheritens.interface_class_hierarchy;

public class Pyramid implements Shape{
    private double h;
    private double s;

    @Override
    public double getVelume() {
        return h * s * 4 / 3;
    }


    public Pyramid(double h, double s) {
        this.h = h;
        this.s = s;
    }
}
