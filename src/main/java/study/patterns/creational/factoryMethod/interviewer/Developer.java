package study.patterns.creational.factoryMethod.interviewer;

public class Developer implements Interviewer{
    @Override
    public void askQuestion() {
        System.out.println("Asking about design patterns!");
    }
}
