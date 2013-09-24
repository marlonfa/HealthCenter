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
public class HistoricoClinicoControle {
    
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
    
    public Object find(Object id) {
        return this.historicoClinicoDao.find(id);
    }

    public List findAll() {
        return this.historicoClinicoDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.historicoClinicoDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Object object) {
        this.historicoClinicoDao.saveOrUpdate((HistoricoClinico) object);
    }

    public void delete(Object object) {
        this.historicoClinicoDao.delete((HistoricoClinico) object);
    }
    
}
