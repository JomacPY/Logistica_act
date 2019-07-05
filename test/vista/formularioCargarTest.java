/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matias
 */
public class formularioCargarTest {
    
    public formularioCargarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of mostrardatos method, of class formularioCargar.
     */
    @Test
    public void testMostrardatos() {
        System.out.println("mostrardatos");
        Object valor = null;
        formularioCargar instance = new formularioCargar();
        instance.mostrardatos(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class formularioCargar.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        formularioCargar.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
