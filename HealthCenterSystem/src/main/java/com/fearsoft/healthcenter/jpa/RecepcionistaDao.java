/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Recepcionista;
import java.util.List;

/**
 *
 * @author marlon
 */
public class RecepcionistaDao extends AbstractDao<Recepcionista>{
    
    public RecepcionistaDao(){
        super(Recepcionista.class);
    }

    @Override
    public List<Recepcionista> findCustom(Long id) {
        return null;    
    }
}
