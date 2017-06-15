package com.edutilos.designpattern.template;

/**
 * Created by edutilos on 16.06.17.
 */
public class Browser extends Software {
    @Override
    public void start() {
        System.out.println("Browser was started.");
    }

    @Override
    public void use() {
        System.out.println("Browser was used.");
    }

    @Override
    public void close() {
        System.out.println("Brower was closed.");
    }
}
