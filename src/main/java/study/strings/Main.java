package study.strings;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringS.isPolindrom("fghgf\t"));
        System.out.println(StringS.isPolindrom("fghhgf\t\n"));
        System.out.println(StringS.getMaxString("fghhgf asldkfj aldkjs hfaslkjdf halsdkjf halsdfkj hdkljsf h"));
        System.out.println(Arrays.toString(StringS.getFriquencyLetter("fghhgf")));
        System.out.println(Arrays.toString(StringS.getFriquencyLetter("fghhgf asldkfj aldkjs hfaslkjdf halsdkjf halsdfkj hdkljsf h")));
    }
}
