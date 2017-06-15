package com.edutilos.designpattern.mvc;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        Person model =new Person(1, "foo", 10, 100.0, true);
        PersonView view = new PersonView();
        PersonController controller = new PersonController(model, view);
       controller.updateView();
        System.out.println();
        controller.setModelName("new_foo");
        controller.updateView();
    }
}
