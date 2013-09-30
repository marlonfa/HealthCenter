/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Consulta;
import java.util.List;

/**
 *
 * @author marlon
 */
public class ConsultaDao extends AbstractDao<Consulta>{
    
    public ConsultaDao(){
        super(Consulta.class);
    }

    @Override
    public List<Consulta> findCustom(Long id) {
        return null;
    }
}
