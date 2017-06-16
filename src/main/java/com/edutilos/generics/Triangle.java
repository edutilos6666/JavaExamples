package com.edutilos.generics;

/**
 * Created by edutilos on 16.06.17.
 */
public class Triangle implements  Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }




    @Override
    public double perimeter() {
        return (a+b+c)/2;
    }

    @Override
    public double area() {
        double S = perimeter()/2 ;
        return Math.sqrt(S*(S-a)*(S-b)*(S-c));
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("Triangle(%.2f,%.2f,%.2f", a, b, c);
    }
}
