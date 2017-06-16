package com.edutilos.generics;

/**
 * Created by edutilos on 16.06.17.
 */
public class Rectangle implements Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double perimeter() {
        return 2*(a+b);
    }

    @Override
    public double area() {
        return a*b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("Rectangle(%.2f,%.2f)",a, b);
    }
}
