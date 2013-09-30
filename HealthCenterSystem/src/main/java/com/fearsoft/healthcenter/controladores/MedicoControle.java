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
public class MedicoControle implements InterfaceControle<Medico>{
    
    private Medico medico;
    private MedicoDao medicoDao;
    
    public MedicoControle(){
        this.medicoDao = new MedicoDao();
        this.medico = new Medico();
    }
    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    @Override
    public Object find(Long id) {
        return this.medicoDao.find(id);
    }

    @Override
    public List findAll() {
        return this.medicoDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.medicoDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Medico object) {
        this.medicoDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Medico object) {
        this.medicoDao.delete(object);
    }


    
    
}
