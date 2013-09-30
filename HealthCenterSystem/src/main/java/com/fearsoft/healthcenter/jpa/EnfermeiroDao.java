/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Enfermeiro;
import java.util.List;

/**
 *
 * @author marlon
 */
public class EnfermeiroDao extends AbstractDao<Enfermeiro>{
    
    public EnfermeiroDao() {
        super(Enfermeiro.class);
    }

    @Override
    public List<Enfermeiro> findCustom(Long id) {
        return null;
    }
}
