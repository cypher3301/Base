package study.patterns.creational.factoryMethod;

public abstract class Dialog {
    public void renderWindow(){
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}
