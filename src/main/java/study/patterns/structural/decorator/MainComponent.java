package study.patterns.structural.decorator;

public class MainComponent implements InterfaceComponent {
    @Override
    public Object doOperation() {
        System.out.println("World");
        return 10;
    }
}
