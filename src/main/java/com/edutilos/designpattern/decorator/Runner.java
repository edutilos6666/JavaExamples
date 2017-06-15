package com.edutilos.designpattern.decorator;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        LaptopComponent comp = new OS(
                new RAM(new CPU(new MotherBoard()))
        );

        comp.install();
    }
}
