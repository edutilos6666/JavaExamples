package com.edutilos.designpattern.factory;

/**
 * Created by edutilos on 15.06.17.
 */
public class ShapeFactory {

    private static ShapeFactory instance = null;
    private ShapeFactory() {

    }

    public static ShapeFactory newInstance() {
        if(instance == null)
            instance = new ShapeFactory();

        return instance;
    }


    public Shape getShape(ShapeTypes type, double... args) {
        Shape shape = null ;
        switch(type) {
            case TRIANGLE:
                shape = new Triangle(args[0], args[1], args[2]);
                break;
            case RECTANGLE:
                shape = new Rectangle(args[0],args[1]);
                break;
            case CIRCLE:
                shape = new Circle(args[0]);
                break;
        }
        return shape;
    }
}
