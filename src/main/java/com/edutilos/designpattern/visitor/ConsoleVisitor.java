package com.edutilos.designpattern.visitor;

/**
 * Created by edutilos on 16.06.17.
 */
public class ConsoleVisitor implements  Visitor {
    @Override
    public void visit(CustomClazz clazz) {
        System.out.println(String.format("Console Visiting: %s", clazz.getName()));
    }
}
