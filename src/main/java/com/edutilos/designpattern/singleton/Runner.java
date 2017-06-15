package com.edutilos.designpattern.singleton;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        SingletonClazz instance = SingletonClazz.newInstance();
        System.out.println(instance.toString());

        instance = SingletonClazz.newInstance();
        System.out.println(instance.toString());
    }
}
