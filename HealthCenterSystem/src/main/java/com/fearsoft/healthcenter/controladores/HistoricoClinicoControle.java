/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.acoes.HistoricoClinico;
import com.fearsoft.healthcenter.jpa.HistoricoClinicoDao;
import java.util.List;

/**
 *
 * @author Eder Ferreira
 */
public class HistoricoClinicoControle implements InterfaceControle<HistoricoClinico> {

    private HistoricoClinico historicoClinico;
    private HistoricoClinicoDao historicoClinicoDao;

    public HistoricoClinicoControle() {
        this.historicoClinico = new HistoricoClinico();
        this.historicoClinicoDao = new HistoricoClinicoDao();
    }

    public HistoricoClinico getHistoricoClinico() {
        return historicoClinico;
    }

    public void setHistoricoClinico(HistoricoClinico historicoClinico) {
        this.historicoClinico = historicoClinico;
    }

    @Override
    public Object find(Long id) {
        return this.historicoClinicoDao.find(id);
    }

    @Override
    public List findAll() {
        return this.historicoClinicoDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Object valor) {
        return this.historicoClinicoDao.findFilter(parametro, valor);
    }
    
    public List findCustom(Long id){
        return this.historicoClinicoDao.findCustom(id);
    }

    @Override
    public void saveOrUpdate(HistoricoClinico object) {
        this.historicoClinicoDao.saveOrUpdate(object);
    }

    @Override
    public void delete(HistoricoClinico object) {
        this.historicoClinicoDao.delete(object);
    }
}
