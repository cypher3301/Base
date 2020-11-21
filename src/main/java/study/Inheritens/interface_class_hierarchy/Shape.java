package study.Inheritens.interface_class_hierarchy;

public interface Shape extends Comparable<Shape>{
    double getVelume();

    @Override
    default int compareTo(Shape o){
        return Double.compare(getVelume(),o.getVelume());
    }


}
