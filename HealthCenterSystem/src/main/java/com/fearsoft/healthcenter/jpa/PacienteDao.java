/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Paciente;
import java.util.List;

/**
 *
 * @author marlon
 */
public class PacienteDao extends AbstractDao<Paciente>{
    
    public PacienteDao(){
        super(Paciente.class);
    }

    @Override
    public List<Paciente> findCustom(Long id) {
        return null;
    }
}
