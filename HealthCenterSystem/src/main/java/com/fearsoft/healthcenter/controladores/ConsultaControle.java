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
public class ConsultaControle {
    
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
    
    public Object find(Object id) {
        return this.consultaDao.find(id);
    }

    public List findAll() {
        return this.consultaDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.consultaDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Object object) {
        this.consultaDao.saveOrUpdate((Consulta) object);
    }

    public void delete(Object object) {
        this.consultaDao.delete((Consulta) object);
    }
}