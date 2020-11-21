package AI.AI;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InNeuron[] neuron;
        int length = 256;
        int maxValue = 255;
        neuron = new InNeuron[length];
//        double[] arrayRand = new double[length];
//        double[] arrayMax = new double[length];
        for (int i = 0; i < length; i++) {
            neuron[i] = new InNeuron(new Random().nextInt(maxValue));
            neuron[i].setNornalize(maxValue);//for nurmalization
        }
    }
}
