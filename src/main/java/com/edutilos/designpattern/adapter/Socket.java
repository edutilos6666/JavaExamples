package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
