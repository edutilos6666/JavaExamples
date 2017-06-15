package com.edutilos.designpattern.observer;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        ObservablePerson person = new ObservablePerson("foo", 10);
        CustomObserver o1, o2, o3;
        o1 = new ConsoleObserver();
        o2 = new EmailObserver();
        o3 = new PrinterObserver();
        o1.subscribe(person);
        o2.subscribe(person);
        o3.subscribe(person);

        person.setName("new_foo");
        person.setAge(55);


        o3.unsubscribe(person);
        person.setAge(66);
    }
}
