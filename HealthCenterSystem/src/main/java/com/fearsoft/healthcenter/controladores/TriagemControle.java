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
        triagemDao = new TriagemDao();
        triagem = new Triagem();
    }
    
    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Object find(Triagem id) {
        return this.triagemDao.find(id);
    }

    public List findAll() {
        return this.triagemDao.findAll();
    }

    public List findFilter(String parametro, Triagem valor) {
        return this.triagemDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Triagem object) {
        this.triagemDao.saveOrUpdate(object);
    }

    public void delete(Triagem object) {
        this.triagemDao.delete(object);
    }
    
    
}
