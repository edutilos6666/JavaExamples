package com.edutilos.designpattern.decorator;

/**
 * Created by edutilos on 15.06.17.
 */
public class OS implements  LaptopComponent{
    private LaptopComponent comp;

    public OS(LaptopComponent comp) {
        this.comp = comp;
    }

    @Override
    public void install() {
        comp.install();
        System.out.println("OS was installed.");
    }
}

