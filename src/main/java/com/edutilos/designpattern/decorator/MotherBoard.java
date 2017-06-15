package com.edutilos.designpattern.decorator;

/**
 * Created by edutilos on 15.06.17.
 */
public class MotherBoard implements LaptopComponent {
    @Override
    public void install() {
        System.out.println("MotherBoard was installed.");
    }
}
