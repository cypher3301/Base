package study.patterns.creational.factoryMethod;

public class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test button</button>");
    }


    public void onClick() {
        System.out.println("Click! 'Hello'");

    }
}


