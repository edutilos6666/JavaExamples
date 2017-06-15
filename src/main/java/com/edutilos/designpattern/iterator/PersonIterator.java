package com.edutilos.designpattern.iterator;

import com.edutilos.designpattern.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class PersonIterator implements CustomIterator<Person> {
    private List<Person> list ;
    private int i = 0 ;
    public PersonIterator() {
        list = new ArrayList<>();
    }


    @Override
    public boolean hasNext() {
        return i < list.size();
    }

    @Override
    public Person next() {
        return list.get(i++);
    }

    @Override
    public void addElement(Person elem) {
        list.add(elem);
    }
}
