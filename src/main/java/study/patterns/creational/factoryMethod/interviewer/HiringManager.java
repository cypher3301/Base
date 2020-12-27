package study.patterns.creational.factoryMethod.interviewer;

public abstract class HiringManager {
    abstract public Interviewer makeInterviewer();
    public void takeInterviewer(){
        Interviewer interviewer = this.makeInterviewer();
        interviewer.askQuestion();
    }
}
