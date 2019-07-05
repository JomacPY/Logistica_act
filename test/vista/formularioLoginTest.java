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
public class formularioLoginTest {
    
    public formularioLoginTest() {
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
     * Test of centrarFormulario method, of class formularioLogin.
     */
    @Test
    public void testCentrarFormulario() {
        System.out.println("centrarFormulario");
        formularioLogin instance = new formularioLogin();
        instance.centrarFormulario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceder method, of class formularioLogin.
     */
    @Test
    public void testAcceder() {
        System.out.println("acceder");
        String usuario = "";
        String pass = "";
        formularioLogin instance = new formularioLogin();
        instance.acceder(usuario, pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class formularioLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        formularioLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
