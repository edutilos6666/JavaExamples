package com.edutilos.designpattern.strategy;

/**
 * Created by edutilos on 16.06.17.
 */
public class MathSubtract implements  MathAlgorithm {
    @Override
    public double calculate(double x, double y) {
        return x - y;
    }
}
