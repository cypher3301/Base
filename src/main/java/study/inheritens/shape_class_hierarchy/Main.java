package study.inheritens.shape_class_hierarchy;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2,2);
        Piramid piramid = new Piramid(100,100);
        Box box = new Box(1000);
        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(piramid));
    }
}
