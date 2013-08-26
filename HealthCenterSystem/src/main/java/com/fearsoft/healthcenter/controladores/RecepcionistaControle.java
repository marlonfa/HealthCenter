/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Recepcionista;
import com.fearsoft.healthcenter.jpa.RecepcionistaDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class RecepcionistaControle{

    private Recepcionista recepcionista;
    private RecepcionistaDao recepcionistaDao;
    
    public RecepcionistaControle(){
        this.recepcionista = new Recepcionista();
        this.recepcionistaDao = new RecepcionistaDao();
    }
    
    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public RecepcionistaDao getRecepcionistaDao() {
        return recepcionistaDao;
    }

    public void setRecepcionistaDao(RecepcionistaDao recepcionistaDao) {
        this.recepcionistaDao = recepcionistaDao;
    }
    
    
    public Object find(Object id){
        return this.recepcionistaDao.find(id);
    }
    
    
    public List findAll(){
        return this.recepcionistaDao.findAll();
    }
    
    
    public List findFilter(String parametro, Object valor){
        return this.recepcionistaDao.findFilter(parametro, valor);
    }
    
    
    public void createOrSave(Object object){
        this.recepcionistaDao.persist((Recepcionista) object);
    }
    
    
    public void delete(Object object){
        this.recepcionistaDao.delete((Recepcionista) object);
    }
}