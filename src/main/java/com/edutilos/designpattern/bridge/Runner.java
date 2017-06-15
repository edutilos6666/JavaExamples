package com.edutilos.designpattern.bridge;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        Person p = new Person(1, "foo", 10 , 100.0, true);
        printPerson(p, new PersonPrinterColored());
        printPerson(p , new PersonPrinterBlackWhite());
    }

    //here bridge pattern , printer is passed as Interface , not a concrete class
    private static void printPerson(Person p, PersonPrinter printer) {
        printer.print(p);
    }
}
