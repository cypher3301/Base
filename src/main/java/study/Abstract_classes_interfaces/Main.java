package Abstract_classes_interfaces;

public class Main {
    public static void main(String[] args) {
        System.out.println(new CelsiumConverter().getConvertedValue(53));
        System.out.println(new KelvinConverter().getConvertedValue(53));
        System.out.println(new FarengateConverter().getConvertedValue(53));

    }
}
