package com.edutilos.designpattern.adapter;

/**
 * Created by edutilos on 15.06.17.
 */
public interface MultiSocket {
   Volt getVolt120();
   Volt getVolt12();
   Volt getVolt3();
}
