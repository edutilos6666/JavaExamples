package com.edutilos.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class SimpleMathTest {
    private SimpleMath sm ;
    @BeforeMethod
    public void setUp() throws Exception {
        sm = new SimpleMath();
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdd() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(13 , sm.add(n1, n2), 0.0);
    }

    @Test
    public void testSubtract() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(7 , sm.subtract(n1, n2), 0.0);
    }

    @Test
    public void testMultiply() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(30, sm.multiply(n1, n2), 0.0);
    }

    @Test
    public void testDivide() throws Exception {
       double n1 = 10 , n2 = 3 ;
       assertEquals(3.33 , sm.divide(n1, n2), 0.1);
    }

    @Test
    public void testModulo() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(1 , sm.modulo(n1, n2), 0.0);
    }

}