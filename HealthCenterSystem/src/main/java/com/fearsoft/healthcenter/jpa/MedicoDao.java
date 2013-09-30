/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;
import com.fearsoft.healthcenter.entidades.Medico;
import java.util.List;

/**
 *
 * @author marlon
 */
public class MedicoDao extends AbstractDao<Medico>{
    
    public MedicoDao(){
        super(Medico.class);
    }

    @Override
    public List<Medico> findCustom(Long id) {
        return null;
    }
}
