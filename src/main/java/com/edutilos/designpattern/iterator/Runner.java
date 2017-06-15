package com.edutilos.designpattern.iterator;

import com.edutilos.designpattern.Person;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        CustomIterator<Person> it = new PersonIterator();
        it.addElement(new Person(1, "foo", 10, 100.0, true));
        it.addElement(new Person(2, "bar", 20, 200.0, false));
        it.addElement(new Person(3, "bim", 30 , 300.0, true));

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
