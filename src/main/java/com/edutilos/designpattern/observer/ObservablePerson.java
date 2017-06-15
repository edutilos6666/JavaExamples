package com.edutilos.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class ObservablePerson {
    private String name;
    private int age ;
    private List<CustomObserver> list = new ArrayList<>();

    public ObservablePerson(String name, int age) {
        this.name = name;
        this.age = age;
        notifyAllObservers();
    }

    public void registerObserver(CustomObserver customObserver) {
        list.add(customObserver);
    }

    public void unregisterObserver(CustomObserver customObserver) {
        list.remove(customObserver);
    }

    public void notifyAllObservers() {
        for(CustomObserver customObserver : list) {
            customObserver.update();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyAllObservers();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyAllObservers();
    }

    @Override
    public String toString() {
        return String.format("[%s,%d]", name, age);
    }
}
