package com.edutilos.designpattern.template;

/**
 * Created by edutilos on 16.06.17.
 */
public class Editor extends Software {
    @Override
    public void start() {
        System.out.println("Editor was started.");
    }

    @Override
    public void use() {
        System.out.println("Editor was used.");
    }

    @Override
    public void close() {
        System.out.println("Editor was closed.");
    }
}
