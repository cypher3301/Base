package study.Collectons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Lists {
    public static void main(String[] args) {
//        putNumber(5);
        getNumber(500, 10000000);
    }

    private static void getNumber(int count, int n) {
            List<Integer> integerArrayList1 = new ArrayList<>();
            List<Integer> integerLinkedList2 = new LinkedList<Integer>();


            for (int i = 0; i < n; i++) {
                integerArrayList1.add(new Random().nextInt());
                integerLinkedList2.add(new Random().nextInt());

            }
        long start = System.nanoTime();
        for (int j = 0; j < count; j++) {
            integerArrayList1.get(new Random().nextInt(n));
        }
        long finish = System.nanoTime();
        double time = finish-start;


        start = System.nanoTime();
        for (int j = 0; j < count; j++) {
            integerLinkedList2.get(new Random().nextInt(n));
        }
        finish = System.nanoTime();

        System.out.println("integerArrayList1: "+time);
        System.out.println("integerLinkedList2: "+(finish-start));
        System.out.println(time/(finish-start));
        System.out.println();
    }

    public static void putNumber(int count){
        for (int j = 0; j < count; j++) {
            List<Integer> integerArrayList1 = new ArrayList<>();
            List<Integer> integerLinkedList2 = new LinkedList<Integer>();


            double start = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                integerArrayList1.add(new Random().nextInt());
            }
            double finish = System.currentTimeMillis();
            double time = finish-start;

            start = System.currentTimeMillis();
            for (int i = 0; i < 10000000; i++) {
                integerLinkedList2.add(new Random().nextInt());
            }
            finish = System.currentTimeMillis();

            System.out.println("integerArrayList1: "+time);
            System.out.println("integerLinkedList2: "+(finish-start));
            System.out.println(time/(finish-start));
            System.out.println();
        }
    }
}
