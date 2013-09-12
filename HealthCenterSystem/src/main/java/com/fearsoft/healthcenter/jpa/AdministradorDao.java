/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Administrador;

/**
 *
 * @author marlon
 */
public class AdministradorDao extends AbstractDao<Administrador>{
    
    public AdministradorDao(){
        super(Administrador.class);
    }
}
