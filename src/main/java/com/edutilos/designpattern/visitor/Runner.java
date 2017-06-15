package com.edutilos.designpattern.visitor;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        CustomClazz clazz = new CustomClazz("foo.bar");
        Visitor v1 , v2 , v3 ;
        v1 = new ConsoleVisitor();
        v2 = new FileVisitor();
        v3 = new EmailVisitor();

        clazz.accept(v1);
        clazz.accept(v2);
        clazz.accept(v3);
    }
}
