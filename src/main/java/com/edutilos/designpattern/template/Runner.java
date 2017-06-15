package com.edutilos.designpattern.template;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        Software sw1 , sw2 ;
        sw1 = new Browser();
        sw2 = new Editor();
        sw1.all();
        System.out.println();
        sw2.all();
    }
}
