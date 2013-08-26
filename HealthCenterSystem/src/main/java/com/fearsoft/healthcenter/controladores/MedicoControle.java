/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.jpa.MedicoDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class MedicoControle{
    
    private Medico medico;
    private MedicoDao medicoDao;
    
    public MedicoControle(){
        this.medico = new Medico();
        this.medicoDao = new MedicoDao();
    }
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public MedicoDao getMedicoDao() {
        return medicoDao;
    }

    public void setMedicoDao(MedicoDao medicoDao) {
        this.medicoDao = medicoDao;
    }
    
    
    public Object find(Object id){
        return this.medicoDao.find(id);
    }
    
    
    public List findAll(){
        return this.medicoDao.findAll();
    }
    
    
    public List findFilter(String parametro, Object valor){
        return this.medicoDao.findFilter(parametro, valor);
    }
    
    
    public void createOrSave(Object object){
        this.medicoDao.persist((Medico) object);
    }
    
    
    public void delete(Object object){
        this.medicoDao.delete((Medico) object);
    }
}
