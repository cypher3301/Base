package ai;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Network {
    int layers;
    Neuron[][] neurons;
    double[][][] weights;
    int[] size;

    double sigm_pro(double x) {
        if ((abs(x - 1) < 1e-9) || (abs(x) < 1e-9)) return 0.0;
        return x * (1.0 - x);
    }

    double predict(double x) {
        if (x >= 0.8) return 1;
        else return 0;
    }

    void setLayers(int n, int[] p) {
        layers = n;
        neurons = new Neuron[n][];
        weights = new double[n - 1][][];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = p[i];
            neurons[i] = new Neuron[p[i]];
            if (i < n - 1) {
                weights[i] = new double[p[i]][];
                for (int j = 0; j < p[i]; j++) {
                    weights[i][j] = new double[p[i + 1]];
                    for (int k = 0; k < p[i + 1]; k++) {
                        weights[i][j][k] = (random() % 100) * 0.01 / size[i];
                    }
                }
            }
        }
    }

    void set_input(double[] p) {
        for (int i = 0; i < size[0]; i++) {
            neurons[0][i].value = p[i];
        }
    }

//    void show()

    void LayersClinear(int LayerNumber, int start, int stop) {
        for (int i = start; i < stop; i++) {
            neurons[LayerNumber][i].value = 0;
        }
    }

    void FeederForward(int LayerNumber, int start, int stop) {
        for (int j = start; j < stop; j++) {
            for (int k = 0; k < size[LayerNumber - 1]; k++) {
                neurons[LayerNumber][j].value += neurons[LayerNumber - 1][k].value * weights[LayerNumber - 1][k][j];
            }
            neurons[LayerNumber][j].act();
        }
    }

    double FeedForward(){
        for (int i = 1; i < layers; i++) {
            LayersClinear(i,0,size[i]);
            FeederForward(i,0,size[i]);
        }

        double max = 0;
        double prediction = 0;
        for (int i = 0; i < size[layers - 1]; i++) {
            if (neurons[layers-1][i].value>max){
                max=neurons[layers-1][i].value;
                prediction=i;
            }
        }
        return prediction;
    }

    void ErrorCoiunter(int LayerNumber, int start, int stop, double predicton, double rresult, double lr){
        if (LayerNumber==layers-1){
            for (int i = start; i < stop; i++) {
                if (i!=(int)rresult){
                    neurons[LayerNumber][i].error=-(neurons[LayerNumber][i].value);
                }else {
                    neurons[LayerNumber][i].error=1.0-(neurons[LayerNumber][i].value);
                }
            }
        } else {
            for (int i = start; i < stop; i++) {
                double error = 0;
                for (int j = 0; j < size[LayerNumber + 1]; j++) {
                    error+=neurons[LayerNumber+1][j].error*weights[LayerNumber][i][j];
                }
                neurons[LayerNumber][i].error=error;
            }
        }
    }

    void WeightsUpdater(int start, int stop,int LayerNum, int lr){
        int i = LayerNum;
        for (int j = start; j < stop; j++) {
            for (int k = 0; k < size[i+1]; k++) {
                weights[i][j][k]+=lr*neurons[i+1][k].error*sigm_pro(neurons[i+1][k].value)*neurons[i][j].value;
            }
        }
    }

    //back propagation


    boolean saveWeights(){
        try {
            FileWriter fileWriter = new FileWriter(new File("weight.txt"));
            for (int i = 0; i < layers; i++) {
                if(i<layers-1){
                    for (int j = 0; j < size[i]; j++) {
                        for (int k = 0; k < size[i + 1]; k++) {
                            String s = weights[i][j][k]+" ";
                            fileWriter.write(s);
                        }
                        fileWriter.write("\n");
                    }
                    fileWriter.write("\n\n\n");
                }
            }
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
