package Strings.Buffer_Builder;

public class Main {
    public static void main(String[] args) {

        System.out.println("StringBuffer - потокобезопастный и синхронизируемый");
        System.out.println("StringBuilder - для однопоточности");
        System.out.println("Оба работают быстрее чем String");

        StringBuffer stringBuffer ;
        StringBuilder stringBuilder;

        String s = "Java";
        stringBuffer = new StringBuffer(s);
        System.out.println(stringBuffer.capacity());
        stringBuffer.ensureCapacity(32);
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.toString());

        String s1 = "+380974728267";
        String s2 = "380974728267";
        String s3 = "0974728267";
        boolean res1 = s1.matches("(\\+)\\d{12}|\\d{12}|\\d{10}");
        boolean res2 = s2.matches("(\\+)\\d{12}|\\d{12}|\\d{10}");
        boolean res3 = s3.matches("(\\+)\\d{12}|\\d{12}|\\d{10}");
//        boolean res2 = s2.matches("\\d{12}");
//        boolean res3 = s1.matches("\\d{10}");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
