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
public class FilaTriagemControle implements InterfaceControle<FilaTriagem>{
    
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
    
    @Override
    public Object find(Long id) {
        return this.filaTriagemDao.find(id);
    }

    @Override
    public List findAll() {
        return this.filaTriagemDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.filaTriagemDao.findFilter(parametro, valor);
    }

    @Override
    public void saveOrUpdate(FilaTriagem object) {
        this.filaTriagemDao.saveOrUpdate(object);
    }

    @Override
    public void delete(FilaTriagem object) {
        this.filaTriagemDao.delete(object);
    }
    
    public void findCustom(Long id){
        this.filaTriagemDao.findCustom(id);
    }

}
