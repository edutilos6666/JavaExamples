package com.edutilos.designpattern.decorator;

/**
 * Created by edutilos on 15.06.17.
 */
public class CPU implements  LaptopComponent {
    private LaptopComponent comp;

    public CPU(LaptopComponent comp) {
        this.comp = comp;
    }

    @Override
    public void install() {
       comp.install();
        System.out.println("CPU was installed.");
    }
}
