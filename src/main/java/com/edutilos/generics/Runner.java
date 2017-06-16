package com.edutilos.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
       List<Shape> list = new ArrayList<>();
       list.add(new Rectangle(10 , 20));
       list.add(new Triangle(10, 11, 12));
       list.add(new Circle(10));
       printShapes(list);

       basicMath(100, 200);

       List l1 = new ArrayList();
       List<Number> l2 = new ArrayList<>();
       List<Integer> l3 = new ArrayList<>();
       List<Double> l4 = new ArrayList<>();
       addNumbers(l1);
       addNumbers(l2);
       addNumbers(l3);
       //error
       //addNumbers(l4);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }

    private static void printShapes(List<? extends Shape> list) {
        for(Shape sh: list) {
            double perimeter = sh.perimeter();
            double area = sh.area();
            System.out.println(sh.toString());
            System.out.println(String.format("Perimeter: %.2f", perimeter));
            System.out.println(String.format("Area: %2f", area));
            System.out.println();
        }
    }

    private static <T extends Number> void basicMath(T n1, T n2){
        double sum = n1.doubleValue() + n2.doubleValue();
       double mult = n1.doubleValue()* n2.doubleValue();
        System.out.println(String.format("sum = %.2f", sum));
        System.out.println(String.format("mult = %.2f", mult));
    }


    private static void addNumbers(List<? super Integer> list) {
        for(int i=0; i< 10; ++i) {
            list.add(i);
        }
    }

}
