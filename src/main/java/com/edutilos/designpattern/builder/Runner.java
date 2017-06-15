package com.edutilos.designpattern.builder;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        Person p = builder.newPerson()
                .withId(1L)
                .withName("foo")
                .withAge(10)
                .withWage(100.0)
                .withActive(true)
                .get();

        System.out.println(p.toString());
    }
}
