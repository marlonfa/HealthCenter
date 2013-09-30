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
public class PacienteControle implements InterfaceControle<Paciente>{
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

    @Override
    public Object find(Long id) {
        return this.pacienteDao.find(id);
    }

    @Override
    public List findAll() {
        return this.pacienteDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.pacienteDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Paciente object) {
        this.pacienteDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Paciente object) {
        this.pacienteDao.delete(object);
    }

}
