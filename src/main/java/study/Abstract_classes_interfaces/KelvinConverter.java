package Abstract_classes_interfaces;

public class KelvinConverter implements Converter{
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue-273.15;
    }
}
