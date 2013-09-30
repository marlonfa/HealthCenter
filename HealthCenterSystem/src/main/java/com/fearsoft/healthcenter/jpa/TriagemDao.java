/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.entidades.Triagem;
import java.util.List;

/**
 *
 * @author marlon
 */
public class TriagemDao extends AbstractDao<Triagem>{
    
    public TriagemDao(){
        super(Triagem.class);
    }

    @Override
    public List<Triagem> findCustom(Long id) {
        return null;
    }
    
}
