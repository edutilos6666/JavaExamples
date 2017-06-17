package com.edutilos.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edutilos on 17.06.17.
 */
public class SimpleMathTest {
    private SimpleMath sm ;
    @Before
    public void setUp() throws Exception {
        sm = new SimpleMath();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(13, sm.add(n1, n2), 0.0);
    }

    @Test
    public void subtract() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(7 , sm.subtract(n1, n2), 0.0);
    }

    @Test
    public void multiply() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(30 , sm.multiply(n1, n2), 0.0);
    }

    @Test
    public void divide() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(3.33 , sm.divide(n1, n2), 0.1);
    }

    @Test
    public void modulo() throws Exception {
        double n1 = 10 , n2 = 3 ;
        assertEquals(1, sm.modulo(n1, n2), 0.0);
    }

}