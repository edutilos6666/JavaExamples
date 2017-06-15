package com.edutilos.designpattern.strategy;

/**
 * Created by edutilos on 16.06.17.
 */
public class MathContext {
    private MathAlgorithm algo ;
    public MathContext(MathAlgorithm algo) {
        this.algo = algo ;
    }
    public void setAlgo(MathAlgorithm algo) {
        this.algo = algo;
    }
    public MathAlgorithm getAlgo() {
        return this.algo ;
    }
   public double execute(double x, double y) {
       return algo.calculate(x, y);
   }
}
