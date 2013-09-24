/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.acoes.FilaConsulta;
import com.fearsoft.healthcenter.jpa.FilaConsultaDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class FilaConsultaControle {
    
    private FilaConsulta filaConsulta;
    private FilaConsultaDao filaConsultaDao;

    public FilaConsultaControle() {
        this.filaConsultaDao = new FilaConsultaDao();
        this.filaConsulta = new FilaConsulta();
    }

    public FilaConsulta getFilaConsulta() {
        return filaConsulta;
    }

    public void setFilaConsulta(FilaConsulta filaConsulta) {
        this.filaConsulta = filaConsulta;
    }
    
    public Object find(Object id) {
        return this.filaConsultaDao.find(id);
    }

    public List findAll() {
        return this.filaConsultaDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.filaConsultaDao.findFilter(parametro, valor);
    }

    public List findConsultas(){
        return this.filaConsultaDao.findConsultas();
    }
    
    public void saveOrUpdate(Object object) {
        this.filaConsultaDao.saveOrUpdate((FilaConsulta) object);
    }

    public void delete(Object object) {
        this.filaConsultaDao.delete((FilaConsulta) object);
    }
    
}
