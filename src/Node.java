

public class Node {
    
    private int[] usableInputs;
    private double[] weights;
    public double bias;

    public void printWeights() {
        String[] weightsReadable = new String[3];
        for (int i = 0; i < 3; i++) {
            weightsReadable[i] = TextTools.DF.format(weights[i]);
        }
        System.out.printf("R: %s , G: %s , B: %s", weightsReadable[0], weightsReadable[1], weightsReadable[2]);
        System.out.println();
    }

    public Node(int[] usableInputs) {

        this.usableInputs = usableInputs;
        weights = new double[usableInputs.length];

        for (int i = 0; i < usableInputs.length; i++) {
            weights[i] = Math.random();
        }
        bias = Math.random();

    }//end constructor

    protected void adjustWeights(double[] dW, double db) {

        for (int i = 0; i < weights.length; i++) {
            weights[i] -= dW[i] * NeuralNet.alpha;
        }

        bias -= NeuralNet.alpha * db;
    }

    public double run(double... inputs) {

        double output = 0;

        for (int i = 0; i < usableInputs.length; i++) {
            output += inputs[usableInputs[i]] * weights[i];
            //System.out.println(String.format("inputs: %s ; weights: %s ; output: %s", inputs[usableInputs[i]], weights[i], output));
        } 

        return output + bias;

    }

}
