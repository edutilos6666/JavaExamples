package com.edutilos.designpattern.bridge;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class PersonPrinterColored implements PersonPrinter {
    @Override
    public void print(Person person) {
        System.out.println("<<Colored Print>>");
        System.out.println(person.toString());
    }
}
