package AI.AI;

public class OutNeuron extends ShadowNeuron{
//    private double[] inNeuron;
    private double correctItem;
//    private double[] wight;
//    private double displacmentNeuron;
//    private double displacment;

    public OutNeuron(double[] inNeuron, double displacmentNeuron) {
        super(inNeuron,displacmentNeuron);
    }


    public double getCorrectItem() {
        return correctItem;
    }

    public void setCorrectItem(double correctItem) {
        this.correctItem = correctItem;
    }
}
