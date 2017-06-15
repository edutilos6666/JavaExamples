package com.edutilos.designpattern.factory;

/**
 * Created by edutilos on 15.06.17.
 */
public class Triangle implements Shape {
    private double a, b , c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }



    @Override
    public double area() {
        double S = perimeter()/2 ;
        double ret = Math.sqrt(S*(S-a)*(S-b)*(S-c));
        return ret;
    }

    @Override
    public double perimeter() {
        return a+b+c;
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
     return String.format("Triangle(%.2f,%.2f,%.2f)", a, b, c);
     }
}
