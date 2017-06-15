package com.edutilos.designpattern.dao;

import com.edutilos.designpattern.Person;

import java.util.List;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAOImpl();
        dao.save(new Person(1, "foo", 10, 100.0, true));
        dao.save(new Person(2, "bar", 20, 200.0, false));
        List<Person> all = dao.findAll();
        System.out.println(String.format("all size = %d", all.size()));
        Person first = dao.findById(1L);
        System.out.println(first.toString());
        dao.update(1L , new Person(1L, "new_foo", 66, 666.6, false));
        first = dao.findById(1L);
        System.out.println(first.toString());
        dao.remove(1L);
        all = dao.findAll();
        System.out.println(String.format("all size = %d", all.size()));
    }
}
