package com.edutilos.designpattern.strategy;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        MathContext ctx = new MathContext(new MathAdd());
        double x = 10 , y = 3 ;
        double sum = ctx.execute(x, y);
        ctx.setAlgo(new MathSubtract());
        double subtract = ctx.execute(x, y);
        ctx.setAlgo(new MathMultiply());
        double multiply = ctx.execute(x, y);
        ctx.setAlgo(new MathDivide());
        double divide = ctx.execute(x, y);
        System.out.println(String.format("sum = %.2f\nsubtract = %.2f\nmultiply = %.2f\ndivide = %.2f",
                sum , subtract , multiply, divide));
    }
}
