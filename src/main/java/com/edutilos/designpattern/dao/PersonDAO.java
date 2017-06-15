package com.edutilos.designpattern.dao;

import com.edutilos.designpattern.Person;

import java.util.List;

/**
 * Created by edutilos on 16.06.17.
 */
public interface PersonDAO {
  void save(Person person);
  void update(long id, Person newP);
  void remove(long id);
  Person findById(long id);
  List<Person> findAll();
}
