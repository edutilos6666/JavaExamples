package com.edutilos.designpattern.bridge;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class PersonPrinterBlackWhite implements PersonPrinter {
    @Override
    public void print(Person person) {
        System.out.println("<<Black White Print>>");
        System.out.println(person.toString());
    }
}
