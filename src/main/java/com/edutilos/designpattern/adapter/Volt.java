package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class Volt {
   private double volts;

    public Volt(double volts) {
        this.volts = volts;
    }

    public double getVolts() {
        return volts;
    }

    public void setVolts(double volts) {
        this.volts = volts;
    }

    @Override
    public String toString() {
        return String.format("Volt(%.3f)", volts);
    }
}
