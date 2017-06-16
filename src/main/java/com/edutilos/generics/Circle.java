package com.edutilos.generics;

/**
 * Created by edutilos on 16.06.17.
 */
public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI* r;
    }

    @Override
    public double area() {
        return Math.PI* Math.pow(r, 2);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return String.format("Circle(%.2f)", r);
    }
}
