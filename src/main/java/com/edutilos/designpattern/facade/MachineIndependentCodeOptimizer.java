package com.edutilos.designpattern.facade;

/**
 * Created by edutilos on 15.06.17.
 */
public class MachineIndependentCodeOptimizer implements CompilationPhase {
    @Override
    public void execute() {
        System.out.println("Machine Independent Code Optimization was applied.");
    }
}
