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
public class AdministradorControle implements InterfaceControle<Administrador>{
    private Administrador administrador;
    private AdministradorDao administradorDao;

    public AdministradorControle(){
        administradorDao = new AdministradorDao();
    }
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    @Override
    public Object find(Administrador id) {
        return this.administradorDao.find(id);
    }

    @Override
    public List findAll() {
        return this.administradorDao.findAll();
    }

    @Override
    public List findFilter(String parametro, Administrador valor) {
        return this.administradorDao.findFilter(parametro, valor);
    }

    @Override
    public void createOrSave(Administrador object) {
        this.administradorDao.saveOrUpdate(object);
    }

    @Override
    public void delete(Administrador object) {
        this.administradorDao.delete(object);
    }
    
    
}
