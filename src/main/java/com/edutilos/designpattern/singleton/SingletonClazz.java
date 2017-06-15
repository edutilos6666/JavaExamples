package com.edutilos.designpattern.singleton;

/**
 * Created by edutilos on 15.06.17.
 */
public class SingletonClazz {
    private static SingletonClazz instance = null;
    private SingletonClazz() {

    }

    public static SingletonClazz newInstance() {
        if(instance == null) instance = new SingletonClazz();
        return instance;
    }

}
