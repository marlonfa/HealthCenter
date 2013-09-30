/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Consulta;
import com.fearsoft.healthcenter.jpa.ConsultaDao;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ConsultaControle implements InterfaceControle<Consulta>{
    
    private Consulta consulta;
    private ConsultaDao consultaDao;

    public ConsultaControle(){
        this.consultaDao = new ConsultaDao();
        this.consulta = new Consulta();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    @Override
    public Object find(Long id) {
        return this.consultaDao.find(id);
    }

    @Override
    public List findAll() {
        return this.consultaDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.consultaDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Consulta object) {
        this.consultaDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Consulta object) {
        this.consultaDao.delete(object);
    }

}