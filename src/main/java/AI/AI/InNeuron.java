package AI.AI;

public class InNeuron{
    private double input;

    public InNeuron(double input) {
        this.input = input;
    }


    public void setNornalize(double maxInput){
        double local_input;
            local_input=input/maxInput;
        this.input=local_input;
    }

    public double getInput() {
        return input;
    }
}
