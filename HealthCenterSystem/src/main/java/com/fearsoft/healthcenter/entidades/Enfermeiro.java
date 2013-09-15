/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */
@Entity
@Table(name = "enfermeiro")
public class Enfermeiro extends Pessoa implements Serializable{
 
    @Column(length = 20, nullable = false)
    private String coren;
    
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }
}