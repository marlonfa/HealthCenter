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
public class RecepcionistaControle implements InterfaceControle<Recepcionista> {

    private Recepcionista recepcionista;
    private RecepcionistaDao recepcionistaDao;

    public RecepcionistaControle() {
        this.recepcionistaDao = new RecepcionistaDao();
        this.recepcionista = new Recepcionista();
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    @Override
    public List findAll() {
        return this.recepcionistaDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.recepcionistaDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Recepcionista object) {
        this.recepcionistaDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Recepcionista object) {
        this.recepcionistaDao.delete(object);
    }

    @Override
    public Object find(Long id) {
        return this.recepcionistaDao.find(id);
    }
}