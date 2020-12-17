package ai;

public class Neuron {

    double value;
    double error;
    void act(){
        value=1/(1+Math.exp(-value));
    }
//    public static void main(String[] args) {
//        double[][] w1 = {
//                {0.2, 0.2, 0.2},
//                {0.4, 0.4, 0.4},
//                {0.6, 0.6, 0.6}
//        };
//
//        double[] b = {0.8,0.8,0.8};
//    }
//
//    private double active(double x) {
//        return 1/(1+Math.exp(-x));
//    }
//
//    private double feedForvard(int nLayers, double[] x, double[][][] w, double[] b){
//        double[] nodeIn;
//        double[] h = new double[0];
//        for (int l = 0; l < nLayers - 1; l++) {
//            if(l==0) nodeIn=x;
//            else nodeIn=h;
//            h=zerosMatrix(w[l]);
//        }
//        return 0;
//    }
//
//    private double zerosMatrix(double[][] doubles){
//        double[][][] zero = new double[0][][];
//        for (int i = 0; i < zero.length; i++) {
//            for (int j = 0; j < doubles.length; j++) {
//                for (int k = 0; k < doubles[j].length; k++) {
//
//                }
//            }
//        }
//    }
}


