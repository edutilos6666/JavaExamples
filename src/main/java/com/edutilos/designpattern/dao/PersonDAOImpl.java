package com.edutilos.designpattern.dao;

import com.edutilos.designpattern.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edutilos on 16.06.17.
 */
public class PersonDAOImpl implements  PersonDAO {
    private Map<Long , Person>  container ;
    public PersonDAOImpl() {
        if(container == null)
            container =new HashMap<>();
    }
    @Override
    public void save(Person person) {
       container.putIfAbsent(person.getId(), person);
    }

    @Override
    public void update(long id, Person newP) {
     container.put(id , newP);
    }

    @Override
    public void remove(long id) {
      container.remove(id);
    }

    @Override
    public Person findById(long id) {
        Person ret = null;
        ret = container.get(id);
        return ret ;
    }

    @Override
    public List<Person> findAll() {
        List<Person> ret = new ArrayList<>();
        for(Person p: container.values()) ret.add(p);
        return ret ;
    }
}
