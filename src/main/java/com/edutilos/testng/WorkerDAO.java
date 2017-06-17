package com.edutilos.testng;

import java.util.List;

/**
 * Created by edutilos on 17.06.17.
 */
public interface WorkerDAO {
   void save(Worker w);
   void update(long id, Worker newW);
   void remove(long id);
   Worker findById(long id);
   List<Worker> findAll();
}
