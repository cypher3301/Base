package study.patterns.creational.factoryMethod.interviewer;

public class DevelopmentManager extends HiringManager{
    @Override
    public Interviewer makeInterviewer() {
        return new Developer();
    }
}

class MarketingManager extends HiringManager{

    @Override
    public Interviewer makeInterviewer() {
        return new CommunityExecutive();
    }
}

class Main{
    public static void main(String[] args) {
        DevelopmentManager developmentManager = new DevelopmentManager();
        developmentManager.takeInterviewer();

        MarketingManager marketingManager = new MarketingManager();
        developmentManager.takeInterviewer();
    }
}
