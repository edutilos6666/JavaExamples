package com.edutilos.designpattern.visitor;

/**
 * Created by edutilos on 16.06.17.
 */
public class FileVisitor implements  Visitor {
    @Override
    public void visit(CustomClazz clazz) {
        System.out.println(String.format("File Visiting: %s", clazz.getName()));
    }
}
