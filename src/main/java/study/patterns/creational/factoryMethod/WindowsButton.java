package study.patterns.creational.factoryMethod;

public class WindowsButton implements Button {


    public void render() {
        System.out.println("Windows button");
    }

    public void onClick() {
        System.out.println("Click win");
    }
}
