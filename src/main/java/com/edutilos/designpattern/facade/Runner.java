package com.edutilos.designpattern.facade;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        CompilationFacade facade = new CompilationFacade();
        facade.compile();
    }
}
