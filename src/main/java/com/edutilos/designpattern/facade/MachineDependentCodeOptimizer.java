package com.edutilos.designpattern.facade;

/**
 * Created by edutilos on 15.06.17.
 */
public class MachineDependentCodeOptimizer implements CompilationPhase {
    @Override
    public void execute() {
        System.out.println("Machine Dependent Code Optimization was applied.");
    }
}
