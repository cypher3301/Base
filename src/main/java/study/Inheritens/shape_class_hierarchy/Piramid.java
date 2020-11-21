package study.Inheritens.shape_class_hierarchy;

public class Piramid extends Shape {
    private double s;
    private double h;


    public Piramid(double h, double s) {
        super(h*s*4/3);
        this.h=h;
        this.s=s;
    }
}
