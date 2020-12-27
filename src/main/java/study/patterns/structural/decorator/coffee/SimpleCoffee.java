package study.patterns.structural.decorator.coffee;

public abstract class SimpleCoffee implements Coffee {

    @Override
    public double getCost() {
        return 7;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public String getComposition() {
        return "Water, coffee";
    }
}
