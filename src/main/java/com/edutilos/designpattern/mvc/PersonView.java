package com.edutilos.designpattern.mvc;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 16.06.17.
 */
public class PersonView {
    public void printPersonDetails(Person person) {
        System.out.println(String.format("<<Person Details>>\n%s", person.toString()));
    }
}
