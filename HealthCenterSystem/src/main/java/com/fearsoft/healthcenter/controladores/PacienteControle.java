/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Paciente;
import com.fearsoft.healthcenter.jpa.PacienteDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class PacienteControle{
    private Paciente paciente;
    private PacienteDao pacienteDao;
    
    public PacienteControle(){
        this.pacienteDao = new PacienteDao();
        this.paciente = new Paciente();
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PacienteDao getPacienteDao() {
        return pacienteDao;
    }

    public void setPacienteDao(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }
    
    
    public Object find(Object id){
        return this.pacienteDao.find(id);
    }
    
    
    public List findAll(){
        return this.pacienteDao.findAll();
    }
    
    
    public List findFilter(String parametro, Object valor){
        return this.pacienteDao.findFilter(parametro, valor);
    }
    
    
    public void saveOrUpdate(Object object){
        this.pacienteDao.saveOrUpdate((Paciente) object);
    }
    
    
    public void delete(Object object){
        this.pacienteDao.delete((Paciente) object);
    }
}
