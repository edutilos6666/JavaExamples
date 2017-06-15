package com.edutilos.designpattern.factory;

/**
 * Created by edutilos on 15.06.17.
 */
public class Circle implements Shape {
    private double r ;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(r, 2);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*r;
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
