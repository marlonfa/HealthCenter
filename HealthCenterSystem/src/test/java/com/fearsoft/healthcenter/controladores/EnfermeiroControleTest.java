/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Enfermeiro;
import com.fearsoft.healthcenter.jpa.EnfermeiroDao;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Eder Ferreira
 */
public class EnfermeiroControleTest extends TestCase {
    
    public EnfermeiroControleTest(String testName) {
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
     * Test of getEnfermeiro method, of class EnfermeiroControle.
     */
    public void testGetEnfermeiro() {
        System.out.println("getEnfermeiro");
        EnfermeiroControle instance = new EnfermeiroControle();
        Enfermeiro expResult = null;
        Enfermeiro result = instance.getEnfermeiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnfermeiro method, of class EnfermeiroControle.
     */
    public void testSetEnfermeiro() {
        System.out.println("setEnfermeiro");
        Enfermeiro enfermeiro = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        instance.setEnfermeiro(enfermeiro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnfermeiroDao method, of class EnfermeiroControle.
     */
    public void testGetEnfermeiroDao() {
        System.out.println("getEnfermeiroDao");
        EnfermeiroControle instance = new EnfermeiroControle();
        EnfermeiroDao expResult = null;
        EnfermeiroDao result = instance.getEnfermeiroDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnfermeiroDao method, of class EnfermeiroControle.
     */
    public void testSetEnfermeiroDao() {
        System.out.println("setEnfermeiroDao");
        EnfermeiroDao enfermeiroDao = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        instance.setEnfermeiroDao(enfermeiroDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class EnfermeiroControle.
     */
    public void testFind() {
        System.out.println("find");
        Object id = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        Object expResult = null;
        Object result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EnfermeiroControle.
     */
    public void testFindAll() {
        System.out.println("findAll");
        EnfermeiroControle instance = new EnfermeiroControle();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFilter method, of class EnfermeiroControle.
     */
    public void testFindFilter() {
        System.out.println("findFilter");
        String parametro = "";
        Object valor = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        List expResult = null;
        List result = instance.findFilter(parametro, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrSave method, of class EnfermeiroControle.
     */
    public void testCreateOrSave() {
        System.out.println("createOrSave");
        Object object = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        instance.createOrSave(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EnfermeiroControle.
     */
    public void testDelete() {
        System.out.println("delete");
        Object object = null;
        EnfermeiroControle instance = new EnfermeiroControle();
        instance.delete(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
