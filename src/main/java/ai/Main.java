package ai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int  l = 4;
        final int input_l = 256;
        int[] size = {input_l,64,32,10};
        Network network = new Network();
        double[] input = new double[input_l];

        int rresult;
        double res;
        double ra=0;
        int maxra=0;
        int maxreapoch=0;
        final int n = 50;
        boolean to_study=false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("is to study ?\n Enter y for yes or n for read from file\n");
        if(scanner.nextLine()=="y") to_study=true;



        if(to_study){

            network.setLayers(l,size);
            for (int e = 0; ra / n * 100 < 100; e++) {
                double startEpoch=System.currentTimeMillis();
                System.out.println("Epoch # "+e);

                ra=0;
                double w_delta=0;

                try {
                    FileReader fileReader = new FileReader(new File("lib.txt"));
                    for (int i = 0; i < n; i++) {
                        double start = System.currentTimeMillis();
                        for (int j = 0; j < input_l; j++) {
                            input[j] = (int)fileReader.read();
                        }
                    }
                } catch (FileNotFoundException erroe) {
                    erroe.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
