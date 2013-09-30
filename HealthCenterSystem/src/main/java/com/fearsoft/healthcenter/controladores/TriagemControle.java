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
public class TriagemControle implements InterfaceControle<Triagem>{
    
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

    @Override
    public Object find(Long id) {
        return this.triagemDao.find(id);
    }

    @Override
    public List findAll() {
        return this.triagemDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.triagemDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(Triagem object) {
        this.triagemDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Triagem object) {
        this.triagemDao.delete(object);
    }
    
}