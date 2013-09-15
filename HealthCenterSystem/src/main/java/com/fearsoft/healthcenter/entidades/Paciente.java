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
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable{
  
    @Column(length = 16, nullable = false)
    private String sus;
    
    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }
}