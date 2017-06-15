package com.edutilos.designpattern.visitor;

/**
 * Created by edutilos on 16.06.17.
 */
public class EmailVisitor implements  Visitor {
    @Override
    public void visit(CustomClazz clazz) {
        System.out.println(String.format("Email Visiting: %s", clazz.getName()));
    }
}
