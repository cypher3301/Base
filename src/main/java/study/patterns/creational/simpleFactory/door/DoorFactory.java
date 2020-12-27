package study.patterns.creational.simpleFactory.door;

public class DoorFactory {
    public static WoodenDoor makeDoor(double width, double height){
        return new WoodenDoor(width,height);
    }
}

class Main{
    public static void main(String[] args) {
        Door door = DoorFactory.makeDoor(40,180);
        System.out.println(door.getWidth());
        System.out.println(door.getHeight());
    }
}
