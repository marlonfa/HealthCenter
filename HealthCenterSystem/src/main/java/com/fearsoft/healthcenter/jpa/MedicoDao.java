/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;
import com.fearsoft.healthcenter.entidades.Medico;

/**
 *
 * @author marlon
 */
public class MedicoDao extends AbstractDao<Medico>{
    
    public MedicoDao(){
        super(Medico.class);
    }
}
