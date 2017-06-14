package com.edutilos.main;

import java.util.*;

/**
 * Created by edutilos on 14.06.17.
 */
public class PersonDAOImplMem implements PersonDAO {
    private Map<Long , Person> container ;

    public PersonDAOImplMem() {
        if(container == null) {
            container = new HashMap<>();
        }
    }

    @Override
    public void save(Person p) {
          container.putIfAbsent(p.getId(), p);
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
        Person ret = null ;
        ret = container.get(id);
        return ret ;
    }

    @Override
    public List<Person> findAll() {
        List<Person> ret = new ArrayList<>();
        Collection<Person> values = container.values();
        for(Person p: values)
            ret.add(p);
        return ret ;
    }
}
