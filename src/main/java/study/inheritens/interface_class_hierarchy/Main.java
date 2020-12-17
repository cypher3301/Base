package study.inheritens.interface_class_hierarchy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Shape shape = new SolidRevolutionForFunction(new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return Math.cos(aDouble);
            }
        },
                0,10
        );
        System.out.println(shape.getVelume());

        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2,2);
        Pyramid piramid = new Pyramid(100,100);

        Box box = new Box(1000);

        System.out.println(box.add(ball));
        System.out.println(box.add(cylinder));
        System.out.println(box.add(piramid));

        ArrayList<Shape> shapes = box.getShapes();
        Collections.sort(shapes);
    }
}
