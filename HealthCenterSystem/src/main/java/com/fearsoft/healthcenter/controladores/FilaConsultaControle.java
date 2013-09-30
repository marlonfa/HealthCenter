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
public class FilaConsultaControle implements InterfaceControle<FilaConsulta>{
    
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
    
    @Override
    public Object find(Long id) {
        return this.filaConsultaDao.find(id);
    }

    @Override
    public List findAll() {
        return this.filaConsultaDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.filaConsultaDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(FilaConsulta object) {
        this.filaConsultaDao.saveOrUpdate(object);
    }

    @Override
    public void delete(FilaConsulta object) {
        this.filaConsultaDao.delete(object);
    }

     public void findCustom(Long id){
        this.filaConsultaDao.findCustom(id);
    }
}
