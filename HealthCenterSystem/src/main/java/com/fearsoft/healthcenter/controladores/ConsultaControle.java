/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Administrador;
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
        consultaDao = new ConsultaDao();
        consulta = new Consulta();
    }
    

    public Object find(Administrador id) {
        return this.consultaDao.find(id);
    }

    public List findAll() {
        return this.consultaDao.findAll();
    }

    public List findFilter(String parametro, Consulta valor) {
        return this.consultaDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Consulta object) {
        this.consultaDao.saveOrUpdate(object);
    }

    public void delete(Consulta object) {
        this.consultaDao.delete(object);
    }
    
    
}
