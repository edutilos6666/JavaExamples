package com.edutilos.designpattern.decorator;

/**
 * Created by edutilos on 15.06.17.
 */
public class RAM implements  LaptopComponent{

    private LaptopComponent comp;

    public RAM(LaptopComponent comp) {
        this.comp = comp;
    }

    @Override
    public void install() {
        comp.install();
        System.out.println("RAM was installed.");
    }
}
