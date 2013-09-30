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
public class EnfermeiroControle implements InterfaceControle<Enfermeiro>{
    
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
    
    
    @Override
    public Object find(Long id){
        return this.enfermeiroDao.find(id);
    }
    
    
    @Override
    public List findAll(){
        return this.enfermeiroDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.enfermeiroDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Enfermeiro object) {
        this.enfermeiroDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Enfermeiro object) {
        this.enfermeiroDao.delete(object);
    }
    
}