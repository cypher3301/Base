package study.Abstract_classes_interfaces;

import java.util.Arrays;
import java.util.Objects;

public class Filter {
    public static void main(String[] args) {
        Object[] array = new String[]{"asdf","asdfwef","adsfae",null, "asd"};

//        Object[] newArray = (String[]) filter(array, new FilterF() {
//            @Override
//            public boolean applay(Object o) {
//                return o!=null;
//            }
//        });

//        String[] newArray = filter(args,s->s!=null);
        String[] newArray = filter(args, Objects::nonNull);

    }

//    public static Object[] filter(Object[] array, FilterF filterF){
    public static <T> T[] filter(T[] array, FilterF<? super T, Boolean> filterF){
        int offset=0;
        for (int i = 0; i < array.length; i++) {
            if(!filterF.applay(array[i])){
                offset++;
            }else array[i-offset]=array[i];
        }
        return Arrays.copyOf(array, array.length-offset);
    }
}


interface FilterF<T, B> {
    //    public Object[] obj(Object[] objects);
    boolean applay(Object o);
}

