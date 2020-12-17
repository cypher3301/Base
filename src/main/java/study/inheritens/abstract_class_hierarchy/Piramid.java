package study.inheritens.abstract_class_hierarchy;

public class Piramid extends Shape{
    private double s;
    private double h;


    public Piramid(double h, double s) {
        this.h=h;
        this.s=s;
    }

    @Override
    public double getVelome() {
        return h*s*4/3;
    }
}
