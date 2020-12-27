package study.patterns.creational.simpleFactory.door;

public class WoodenDoor implements Door{
    protected double width;
    protected double height;

    public WoodenDoor(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }
}
