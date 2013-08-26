/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Recepcionista;
import com.fearsoft.healthcenter.jpa.RecepcionistaDao;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Eder Ferreira
 */
public class RecepcionistaControleTest extends TestCase {
    
    public RecepcionistaControleTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getRecepcionista method, of class RecepcionistaControle.
     */
    public void testGetRecepcionista() {
        System.out.println("getRecepcionista");
        RecepcionistaControle instance = new RecepcionistaControle();
        Recepcionista expResult = null;
        Recepcionista result = instance.getRecepcionista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecepcionista method, of class RecepcionistaControle.
     */
    public void testSetRecepcionista() {
        System.out.println("setRecepcionista");
        Recepcionista recepcionista = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        instance.setRecepcionista(recepcionista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecepcionistaDao method, of class RecepcionistaControle.
     */
    public void testGetRecepcionistaDao() {
        System.out.println("getRecepcionistaDao");
        RecepcionistaControle instance = new RecepcionistaControle();
        RecepcionistaDao expResult = null;
        RecepcionistaDao result = instance.getRecepcionistaDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecepcionistaDao method, of class RecepcionistaControle.
     */
    public void testSetRecepcionistaDao() {
        System.out.println("setRecepcionistaDao");
        RecepcionistaDao recepcionistaDao = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        instance.setRecepcionistaDao(recepcionistaDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class RecepcionistaControle.
     */
    public void testFind() {
        System.out.println("find");
        Object id = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        Object expResult = null;
        Object result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class RecepcionistaControle.
     */
    public void testFindAll() {
        System.out.println("findAll");
        RecepcionistaControle instance = new RecepcionistaControle();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFilter method, of class RecepcionistaControle.
     */
    public void testFindFilter() {
        System.out.println("findFilter");
        String parametro = "";
        Object valor = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        List expResult = null;
        List result = instance.findFilter(parametro, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrSave method, of class RecepcionistaControle.
     */
    public void testCreateOrSave() {
        System.out.println("createOrSave");
        Object object = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        instance.createOrSave(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class RecepcionistaControle.
     */
    public void testDelete() {
        System.out.println("delete");
        Object object = null;
        RecepcionistaControle instance = new RecepcionistaControle();
        instance.delete(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
