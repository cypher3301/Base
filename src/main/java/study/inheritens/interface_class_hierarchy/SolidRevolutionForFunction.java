package study.inheritens.interface_class_hierarchy;

import java.util.function.Function;

public class SolidRevolutionForFunction extends SolidOfRevolution{
    private Function<Double, Double> function;
    private double a;
    private double b;

    public SolidRevolutionForFunction(Function<Double, Double> function, double a, double b) {
        super(b-a);
        this.function = function;
        this.a = a;
        this.b = b;
    }

    @Override
    public double getVelume() {
        double sum=0;
        int iterations = 1000;
        double delta = (b-a)/iterations;
        for (int i = 0; i < iterations; i++) {
            double x=a+((b-a)*i/iterations);
            sum+=Math.pow(function.apply(x), 2)*delta;
        }
        return Math.PI*sum;
    }
}
