package com.edutilos.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class WorkerDAOImplTest {
    private WorkerDAO dao ;

    @Before
    public void setUp() throws Exception {
      dao = new WorkerDAOImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        assertEquals(3, dao.findAll().size());
    }

    @Test
    public void update() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        assertEquals(3, dao.findAll().size());
        dao.update(1, new Worker(1, "new_foo", 66, 666.6, false));
        Worker first = dao.findById(1L);
        assertEquals(1L, first.getId());
        assertEquals("new_foo", first.getName());
        assertEquals(66, first.getAge());
        assertEquals(666.6 , first.getWage(), 0.0);
        assertEquals(false , first.isActive());
    }

    @Test
    public void remove() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        dao.remove(1L);
        assertEquals(2, dao.findAll().size());
    }

    @Test
    public void findById() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        Worker first = dao.findById(1L);
        assertEquals(1L , first.getId());
        assertEquals("foo", first.getName());
        assertEquals(10 , first.getAge());
        assertEquals(100.0, first.getWage(), 0.0);
        assertEquals(true , first.isActive());

        Worker last = dao.findById(3);
        assertEquals(3L, last.getId());
        assertEquals("bim", last.getName());
        assertEquals(30, last.getAge());
        assertEquals(300.0, last.getWage(), 0.0);
        assertEquals(true , last.isActive());
    }

    @Test
    public void findAll() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        List<Worker> all = dao.findAll();
        assertEquals(3, all.size());
        assertEquals("foo", all.get(0).getName());
        assertEquals(20 , all.get(1).getAge());
        assertEquals(300.0, all.get(2).getWage(), 0.0);
    }

}