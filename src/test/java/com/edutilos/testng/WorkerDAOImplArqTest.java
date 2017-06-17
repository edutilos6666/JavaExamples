package com.edutilos.testng;

import com.edutilos.junit.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class WorkerDAOImplArqTest extends Arquillian {
    @Inject
    private WorkerDAOImpl dao ;
    @BeforeMethod
    public void setUp() throws Exception {
       // dao = new WorkerDAOImpl();
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testSave() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));

        assertEquals(3 , dao.findAll().size());
    }

    @Test
    public void testUpdate() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        dao.update(1, new Worker("new_foo", 66, 666.6, false));
        assertEquals(3, dao.findAll().size());
        Worker w = dao.findById(1L);
        assertEquals(1L, w.getId());
        assertEquals("new_foo", w.getName());
        assertEquals(66, w.getAge());
        assertEquals(666.6 , w.getWage(), 0.0);
        assertEquals(true, w.isActive());
    }

    @Test
    public void testRemove() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        dao.remove(1L);
        assertEquals(2, dao.findAll().size());
    }

    @Test
    public void testFindById() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));
        Worker w = dao.findById(1L);

        assertEquals(1L , w.getId());
        assertEquals("foo", w.getName());
        assertEquals(10, w.getAge());
        assertEquals(100.0, w.getWage(), 0.0);
        assertEquals(true , w.isActive());

        w = dao.findById(3L);
        assertEquals(3L, w.getId());
        assertEquals("bim", w.getName());
        assertEquals(30, w.getAge());
        assertEquals(300.0, w.getWage(), 0.0);
        assertEquals(true , w.isActive());
    }

    @Test
    public void testFindAll() throws Exception {
        dao.save(new Worker(1, "foo", 10, 100.0, true));
        dao.save(new Worker(2, "bar", 20 , 200.0, false));
        dao.save(new Worker(3, "bim", 30, 300.0, true));

        List<Worker> all = dao.findAll();
        assertEquals(100.0, all.get(0).getWage(), 0.0);
        assertEquals(20, all.get(1).getAge());
        assertEquals("bim", all.get(2).getName());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(com.edutilos.testng.WorkerDAOImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
