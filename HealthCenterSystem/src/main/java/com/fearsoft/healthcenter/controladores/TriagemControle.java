/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Triagem;
import com.fearsoft.healthcenter.jpa.TriagemDao;
import java.util.List;

/**
 *
 * @author marlon
 */
public class TriagemControle {
    
    private Triagem triagem;
    private TriagemDao triagemDao;

    public TriagemControle(){
        this.triagem = new Triagem();
        this.triagemDao = new TriagemDao();
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }
    
    public Object find(Object id) {
        return this.triagemDao.find(id);
    }

    public List findAll() {
        return this.triagemDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.triagemDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Object object) {
        this.triagemDao.saveOrUpdate((Triagem) object);
    }

    public void delete(Object object) {
        this.triagemDao.delete((Triagem) object);
    }
}