package study.abstractClassesInterfaces;

import java.util.function.Function;

public class FillArray {
    public static void main(String[] args) {
        Integer[] integers = new Integer[100];
        fill(integers,integer -> integer*integer);
    }

    public static <T> void  fill(T[] ts, Function<Integer, ? extends T> function){
        for (int i = 0; i < ts.length; i++) {
            ts[i] = function.apply(i);
        }
    }
}

