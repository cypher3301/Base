package study.patterns.creational.abstractFactory.door;

//Мы получили абстрактную фабрику, которая позволяет создавать семейства объектов или взаимосвязанные объекты.
// То есть фабрика деревянных дверей создаст деревянную дверь и человека для её монтажа, фабрика стальных
// дверей — стальную дверь и соответствующего специалиста и т. д.

public interface DoorFactory {
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();
}

// Фабрика деревянных дверей возвращает плотника и деревянную дверь
class WoodenDoorFactory implements DoorFactory{

    @Override
    public Door makeDoor() {
        return new WoodenDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}

class IronDoorFactory implements DoorFactory{

    @Override
    public Door makeDoor() {
        return new IronDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}

class Main{
    public static void main(String[] args) {
        WoodenDoorFactory woodenDoorFactory = new WoodenDoorFactory();
        Door door = woodenDoorFactory.makeDoor();
        DoorFittingExpert doorFittingExpert = woodenDoorFactory.makeFittingExpert();

        door.getDescription();
        doorFittingExpert.getDescription();

        IronDoorFactory ironDoorFactory = new IronDoorFactory();
        Door door1 = ironDoorFactory.makeDoor();
        DoorFittingExpert doorFittingExpert1 = ironDoorFactory.makeFittingExpert();

        door1.getDescription();
        doorFittingExpert1.getDescription();
    }
}
