package study.patterns.creational.factoryMethod.interviewer;

public class CommunityExecutive implements Interviewer{
    @Override
    public void askQuestion() {
        System.out.println("Asking about community building");
    }
}
