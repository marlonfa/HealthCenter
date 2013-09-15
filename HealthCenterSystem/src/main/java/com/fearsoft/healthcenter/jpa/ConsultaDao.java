/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Consulta;

/**
 *
 * @author marlon
 */
public class ConsultaDao extends AbstractDao<Consulta>{
    
    public ConsultaDao(){
        super(Consulta.class);
    }
}
