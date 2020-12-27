package study.patterns.creational.abstractFactory.door;

public interface Door {
    void getDescription();
}

class WoodenDoor implements Door{

    @Override
    public void getDescription() {
        System.out.println("I am a wooden door");
    }
}

class IronDoor implements Door{

    @Override
    public void getDescription() {
        System.out.println("I am a iron door");
    }
}
