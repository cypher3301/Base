package study.lambdaExpressions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Operationable operationable;
//        operationable = ((x, y) -> x+y);
        Operationable operationable = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x+y;
            }
        };
//        operationable = ((x, y) -> x+y);


        int result = operationable.calculate(10,20);
        System.out.println(result);


        System.out.println("args = " + Arrays.deepToString(args));


        System.out.println("Отложенное выполнение\n");
        System.out.println("Выполнение кода отдельном потоке");
        System.out.println("Выполнение одного и того же кода несколько раз");
        System.out.println("Выполнение кода в результате какого-то события");
        System.out.println("Выполнение кода только в том случае, когда он действительно необходим и если он необходим");
    }
}

interface Operationable{
    int calculate(int x, int y);
}
