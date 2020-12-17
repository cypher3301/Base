package ai.AI;

import java.util.Random;

public class ShadowNeuron{

    private double[] inNeuron;
    private double[] wight;
    private double displacmentNeuron;

    //////////////////////////////////////////

    public ShadowNeuron(double[] inNeuron, double displacmentNeuron) {
        this.inNeuron = inNeuron;
        this.displacmentNeuron = displacmentNeuron;
    }

    ////////////////////////////////////////

    public void setWight(){
        for (int i = 0; i < wight.length; i++) {
            wight[i]= new Random().nextDouble();//задаем веса случайным образом в диапазоне Double
        }
    }

    public void setDisplacment(){
        displacmentNeuron=new Random().nextDouble();
    }

    public void correctWight(/**/){
        //
    }

    ////////////////////////////////////////

//    @Override
//    public double[] getInput() {
//        return new double[0];
//    }
//
//    @Override
//    public double getItemInput(int index) {
//        return 0;
//    }
//
//    @Override
//    public double getDisplacmentNeuron() {
//        return 0;
//    }

    ///////////////////////////////////////////

    public double activate(){
        double sum =0;
        for (int i = 0; i< inNeuron.length; i++) {
            sum+=inNeuron[i]*wight[i];
        }
        sum+=displacmentNeuron;
        return sigmoid(sum);
    }

    private double sigmoid(double x){
        return 1/(1+Math.exp(-x));
    }
}
