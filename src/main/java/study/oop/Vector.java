package study.oop;

import java.util.Arrays;

public class Vector {
    private final double[] coordinats;

    public double[] getCoordinats() {
        return coordinats;
    }

    public Vector(double[] coordinats) {
        this.coordinats = coordinats;
    }


    public double getLength(){
        double length = 0;
        for (double coordinat : coordinats) {
            length += Math.pow(coordinat, 2);
        }
        return Math.sqrt(length);
    }

    public double getScalar(Vector vector){
        double result = 0;
        for (int i = 0; i < getMin(this,vector); i++) {
            result+=coordinats[i]*vector.coordinats[i];
        }
        return result;
    }

    ////////////////////////////////

    public double getCos(Vector vector){
        return getScalar(vector)/(getLength()*vector.getLength());
    }

    public Vector getVectorSum(Vector vector){
        double[] newCoordinats = new double[(int) getMin(this,vector)];
        for (int i = 0; i < getMin(this,vector); i++) {
            newCoordinats[i]=this.coordinats[i]+vector.getCoordinats()[i];
        }
        return new Vector(newCoordinats);
    }

    public Vector getVectorSub(Vector vector){
        double[] newCoordinats = new double[(int) getMin(this,vector)];
        for (int i = 0; i < getMin(this,vector); i++) {
            newCoordinats[i]=this.coordinats[i]-vector.getCoordinats()[i];
        }
        return new Vector(newCoordinats);
    }

//    public static Vector[] genetate(int n, int range){
//        Vector[] vectors = new Vector[n];
//        double[] coord = new double[range];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < range; j++) {
//                coord[j]=Math.random();
//            }
//            vectors[i] = new Vector(coord);
//        }
//        return vectors;
//    }

    private static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static Vector[] generate(int n, int dimension) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(generateRandomArray(dimension));
        }
        return vectors;
    }



    private static double getMin(Vector vector1, Vector vector2){
        return Math.min(vector1.getCoordinats().length,vector2.getCoordinats().length);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "coordinats=" + Arrays.toString(coordinats) +
                '}';
    }
}
