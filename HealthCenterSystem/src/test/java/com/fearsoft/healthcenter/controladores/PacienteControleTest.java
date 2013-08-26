/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Paciente;
import com.fearsoft.healthcenter.jpa.PacienteDao;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Eder Ferreira
 */
public class PacienteControleTest extends TestCase {
    
    public PacienteControleTest(String testName) {
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
     * Test of getPaciente method, of class PacienteControle.
     */
    public void testGetPaciente() {
        System.out.println("getPaciente");
        PacienteControle instance = new PacienteControle();
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaciente method, of class PacienteControle.
     */
    public void testSetPaciente() {
        System.out.println("setPaciente");
        Paciente paciente = null;
        PacienteControle instance = new PacienteControle();
        instance.setPaciente(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPacienteDao method, of class PacienteControle.
     */
    public void testGetPacienteDao() {
        System.out.println("getPacienteDao");
        PacienteControle instance = new PacienteControle();
        PacienteDao expResult = null;
        PacienteDao result = instance.getPacienteDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPacienteDao method, of class PacienteControle.
     */
    public void testSetPacienteDao() {
        System.out.println("setPacienteDao");
        PacienteDao pacienteDao = null;
        PacienteControle instance = new PacienteControle();
        instance.setPacienteDao(pacienteDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PacienteControle.
     */
    public void testFind() {
        System.out.println("find");
        Object id = null;
        PacienteControle instance = new PacienteControle();
        Object expResult = null;
        Object result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PacienteControle.
     */
    public void testFindAll() {
        System.out.println("findAll");
        PacienteControle instance = new PacienteControle();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFilter method, of class PacienteControle.
     */
    public void testFindFilter() {
        System.out.println("findFilter");
        String parametro = "";
        Object valor = null;
        PacienteControle instance = new PacienteControle();
        List expResult = null;
        List result = instance.findFilter(parametro, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createOrSave method, of class PacienteControle.
     */
    public void testCreateOrSave() {
        System.out.println("createOrSave");
        Object object = null;
        PacienteControle instance = new PacienteControle();
        instance.createOrSave(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PacienteControle.
     */
    public void testDelete() {
        System.out.println("delete");
        Object object = null;
        PacienteControle instance = new PacienteControle();
        instance.delete(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
