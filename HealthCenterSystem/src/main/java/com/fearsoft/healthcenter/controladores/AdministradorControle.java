/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import com.fearsoft.healthcenter.entidades.Administrador;
import com.fearsoft.healthcenter.jpa.AdministradorDao;
import java.util.List;

/**
 *
 * @author marlon
 */
public class AdministradorControle {
    private Administrador administrador;
    private AdministradorDao administradorDao;

    public AdministradorControle(){
        administradorDao = new AdministradorDao();
        administrador = new Administrador();
    }
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Object find(Long id) {
        return this.administradorDao.find(id);
    }

    public List findAll() {
        return this.administradorDao.findAll();
    }

    public List findFilter(String parametro, Object valor) {
        return this.administradorDao.findFilter(parametro, valor);
    }

    public void saveOrUpdate(Administrador object) {
        this.administradorDao.saveOrUpdate(object);
    }

    public void delete(Administrador object) {
        this.administradorDao.delete(object);
    }
    
    
}
