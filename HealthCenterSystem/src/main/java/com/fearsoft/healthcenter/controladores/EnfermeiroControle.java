/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Enfermeiro;
import com.fearsoft.healthcenter.jpa.EnfermeiroDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class EnfermeiroControle{
    
    private Enfermeiro enfermeiro;
    private EnfermeiroDao enfermeiroDao;
    
    public EnfermeiroControle(){
        this.enfermeiroDao = new EnfermeiroDao();
        this.enfermeiro = new Enfermeiro();
    }
    
    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public EnfermeiroDao getEnfermeiroDao() {
        return enfermeiroDao;
    }

    public void setEnfermeiroDao(EnfermeiroDao enfermeiroDao) {
        this.enfermeiroDao = enfermeiroDao;
    }
    
    
    public Object find(Object id){
        return this.enfermeiroDao.find(id);
    }
    
    
    public List findAll(){
        return this.enfermeiroDao.findAll();
    }
    
    
    public List findFilter(String parametro, Object valor){
        return this.enfermeiroDao.findFilter(parametro, valor);
    }
    
    
    public void saveOrUpdate(Object object){
        this.enfermeiroDao.saveOrUpdate((Enfermeiro) object);
    }
    
    
    public void delete(Object object){
        this.enfermeiroDao.delete((Enfermeiro) object);
    }
}