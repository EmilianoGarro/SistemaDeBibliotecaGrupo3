/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabibliotecagrupo3.modelos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class LibroDataTest {
    
    public LibroDataTest() {
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
     * Test of guardarLibro method, of class LibroData.
     */
    @Test
    public void testGuardarLibro() {
        System.out.println("guardarLibro");
        Libro libro = null;
        LibroData instance = null;
        instance.guardarLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarLibro method, of class LibroData.
     */
    @Test
    public void testEliminarLibro() {
        System.out.println("eliminarLibro");
        int id = 0;
        LibroData instance = null;
        instance.eliminarLibro(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarLibro method, of class LibroData.
     */
    @Test
    public void testActualizarLibro() {
        System.out.println("actualizarLibro");
        Libro libro = null;
        LibroData instance = null;
        instance.actualizarLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
