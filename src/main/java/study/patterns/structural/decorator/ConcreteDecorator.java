package study.patterns.structural.decorator;

public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(InterfaceComponent interfaceComponent) {
        super(interfaceComponent);
    }

    @Override
    public Object doOperation() {
        System.out.println("comma");
        return super.doOperation();
    }

    @Override
    public void newOperation() {
        System.out.println("new Comma operation");
//        super.newOperation();
    }
}
