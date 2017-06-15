package com.edutilos.designpattern.factory;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        ShapeFactory factory = ShapeFactory.newInstance();
        Shape tri, rect , circle ;
        tri = factory.getShape(ShapeTypes.TRIANGLE, 10, 11, 12);
        rect = factory.getShape(ShapeTypes.RECTANGLE, 10 , 20);
        circle = factory.getShape(ShapeTypes.CIRCLE, 10);

        System.out.println(tri);
        System.out.println(String.format("area = %.2f", tri.area()));
        System.out.println(String.format("perimeter = %.2f", tri.perimeter()));
        System.out.println();
        System.out.println(rect);
        System.out.println(String.format("area = %.2f", rect.area()));
        System.out.println(String.format("perimeter = %.2f", rect.perimeter()));
        System.out.println();
        System.out.println(circle);
        System.out.println(String.format("area = %.2f", circle.area()));
        System.out.println(String.format("perimeter = %.2f", circle.perimeter()));
    }
}
