package com.edutilos.designpattern.facade;

/**
 * Created by edutilos on 15.06.17.
 */
public class LexicalAnalyzer implements CompilationPhase {
    @Override
    public void execute() {
        System.out.println("Lexical Analysis of code.");
    }
}
