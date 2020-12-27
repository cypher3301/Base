package study.patterns.creational.abstractFactory.door;

public interface DoorFittingExpert {
    void getDescription();
}

class Welder implements DoorFittingExpert{

    @Override
    public void getDescription() {
        System.out.println("I can only fit iron doors");
    }
}
class Carpenter  implements DoorFittingExpert{

    @Override
    public void getDescription() {
        System.out.println("I can only fit wooden  doors");
    }
}
