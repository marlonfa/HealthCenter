/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.acoes.FilaTriagem;
import com.fearsoft.healthcenter.jpa.FilaTriagemDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class FilaTriagemControle {
    
    private FilaTriagem filaTriagem;
    private FilaTriagemDao filaTriagemDao;
    
    public FilaTriagemControle() {
        this.filaTriagem = new FilaTriagem();
        this.filaTriagemDao = new FilaTriagemDao();
    }

    public FilaTriagem getFilaTriagem() {
        return filaTriagem;
    }

    public void setFilaTriagem(FilaTriagem filaTriagem) {
        this.filaTriagem = filaTriagem;
    }
    
    public Object find(Object id) {
        return this.filaTriagemDao.find(id);
    }

    public List findAll() {
        return this.filaTriagemDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.filaTriagemDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Object object) {
        this.filaTriagemDao.saveOrUpdate((FilaTriagem) object);
    }

    public void delete(Object object) {
        this.filaTriagemDao.delete((FilaTriagem) object);
    }
}
