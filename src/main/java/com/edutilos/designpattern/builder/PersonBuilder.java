package com.edutilos.designpattern.builder;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class PersonBuilder {
    private static Person person = null ;
    public  PersonBuilder newPerson() {
       person = new Person();
       return this ;
   }

    public  PersonBuilder withId(long id) {
        person.setId(id);
        return this ;
    }

    public PersonBuilder withName(String name) {
        person.setName(name);
        return this;
    }

    public PersonBuilder withAge(int age) {
        person.setAge(age);
        return this ;
    }

    public PersonBuilder withWage(double wage) {
        person.setWage(wage);
        return this;
    }

    public PersonBuilder withActive(boolean active) {
        person.setActive(active);
        return this;
    }

    public Person get() {
        return person ;
    }

}
