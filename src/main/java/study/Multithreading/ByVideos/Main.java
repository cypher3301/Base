package study.Multithreading.ByVideos;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
       new Main().run();
    }

    private void run() {
        int n = 1000;
        int threads = 4;
        MyThread[] threads1 = new MyThread[threads];
        double[] data = new double[n];
        for (int i = 0; i < threads; i++) {
            threads1[i] = new MyThread(n/threads*i,n/threads*(i+1),new double[n/threads]);
            threads1[i].start();
        }
        try {
            threads1.wait();

            double[] asdjf = new double[data.length*2];
//            Arrays.setAll(asdjf, i->(i<));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public double calc(double d){
//        return new Random();
        return 0;
    }


}

class MyThread extends Thread{
    int start;
    int finish;
    double[] data;

    public MyThread(int start, int finish, double[] data) {
        this.start = start;
        this.finish = finish;
        this.data=data;
    }

    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            data[i] = new Random().nextDouble()*10;
        }
    }

    public double[] getData() {
        return data;
    }
}

class Calculate{
    Point[] points;
    int range;
    int start, finish;
    UnaryOperator<Double> unaryOperator;

    public Calculate(int range, int start, int finish, UnaryOperator<Double> unaryOperator) {
        this.range = range;
        this.start = start;
        this.finish = finish;
        this.unaryOperator = unaryOperator;
    }

    public Point[] getPoints() {
        return points;
    }

    public  void calculate(){
        for (int i = start; i < finish; i++) {

//            unaryOperator.apply();
        }
    }
}
