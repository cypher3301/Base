package study.patterns.structural.decorator.coffee;

public class MilkCoffee implements Coffee{
    protected Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }


    @Override
    public double getCost() {
        return this.coffee.getCost()+2;
    }

    @Override
    public String getDescription() {
        return "Milk coffee";
    }

    @Override
    public String getComposition() {
        return this.coffee.getComposition()+", milk";
    }
}
