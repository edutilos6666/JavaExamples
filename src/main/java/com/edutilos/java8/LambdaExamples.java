package com.edutilos.java8;

import java.util.function.BooleanSupplier;

/**
 * Created by edutilos on 16.06.17.
 */
public class LambdaExamples {
    public static void main(String[] args) {
       test2();
    }
    private static final String newline = "\r\n";






    private static void engine(ISimpleMath ism , double n1, double n2) {
        System.out.println(String.format("double result = %.2f", ism.calculate(n1,n2)));
    }

    private static void engine(IIntSimpleMath ism, int n1 , int n2) {
        System.out.println(String.format("int result = %d", ism.calculate(n1,n2)));
    }

    private static void engine(ILongSimpleMath ism , long n1, long n2) {
        System.out.println(String.format("long result = %d", ism.calculate(n1, n2)));
    }

    private static void engine(ISimpleMath ism ) {
        double n1 = 10 ;  double n2 = 3 ;
        System.out.println(String.format("double result = %.2f", ism.calculate(n1,n2)));
    }

    private static void engine(IIntSimpleMath ism) {
        int n1 = 10 ;  int n2 = 3 ;
        System.out.println(String.format("int result = %d", ism.calculate(n1,n2)));
    }

    private static void engine(ILongSimpleMath ism ) {
        long n1 = 10L;  long n2 = 3L;
        System.out.println(String.format("long result = %d", ism.calculate(n1, n2)));
    }

    private static void test2() {
        double a = 10 , b = 3 ;
        engine((double n1,double  n2)-> n1 + n2);
        engine((long n1, long n2)-> n1 - n2 );
        engine((int n1,int n2)-> n1*n2);
        engine((n1, n2)-> n1/n2, a, b);
        engine((IIntSimpleMath)((n1, n2)-> n1 * n2));
    }


    private static void test1() {
        ISimpleMath mathAdd = (n1,n2)-> n1 + n2 ;
        ISimpleMath mathSubtract = (n1, n2)-> n1 - n2 ;
        ISimpleMath mathMultiply = (n1, n2)-> n1 * n2 ;
        ISimpleMath mathDivide = (n1, n2) -> n1 / n2 ;

        double n1 = 10 , n2 = 3 ;
        double add = mathAdd.calculate(n1,n2),
                subtract = mathSubtract.calculate(n1, n2),
                multiply = mathMultiply.calculate(n1, n2),
                divide = mathDivide.calculate(n1, n2);

        StringBuilder sb = new StringBuilder();
        sb.append("add = ").append(add).append(newline)
                .append("subtract = ").append(subtract).append(newline)
                .append("multiply = ").append(multiply).append(newline)
                .append("divide = ").append(divide).append(newline)
                .append(newline);

        System.out.println(sb.toString());

        BooleanSupplier bs = ()-> true ;
        System.out.println(String.format("bs = %b", bs.getAsBoolean()));
        int age = 10 ;
        bs = ()-> age > 10;
        System.out.println(String.format("bs = %b", bs.getAsBoolean()));
    }


    @FunctionalInterface
    private static interface ISimpleMath {
         double calculate(double n1, double n2);
    }


    @FunctionalInterface
    private static interface IIntSimpleMath {
        int calculate(int n1, int n2);
    }

    @FunctionalInterface
    private static interface ILongSimpleMath {
        long calculate(long n1, long n2);
    }
}
