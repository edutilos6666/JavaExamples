package com.edutilos.main;

import java.util.List;

/**
 * Created by edutilos on 14.06.17.
 */
public interface PersonDAO {
  void save(Person p);
  void update(long id , Person newP);
  void remove(long id);
  Person findById(long id);
  List<Person> findAll();
}
