package Abstract_classes_interfaces;

public class FarengateConverter implements Converter{
    @Override
    public double getConvertedValue(double baseValue) {
        return baseValue*9/5+32;
    }
}
