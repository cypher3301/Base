package study.patterns.structural.decorator;

abstract class Decorator implements InterfaceComponent {
    protected InterfaceComponent interfaceComponent;

    public Decorator(InterfaceComponent interfaceComponent) {
        this.interfaceComponent = interfaceComponent;
    }

    @Override
    public Object doOperation() {
        return interfaceComponent.doOperation();
    }

    public void newOperation(){
        System.out.println("Do nothing");
    }
}
