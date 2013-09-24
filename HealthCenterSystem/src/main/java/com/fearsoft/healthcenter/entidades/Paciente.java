/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */
@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable{
  
    @Column(length = 15, nullable = false)
    private String sus;
  
//    @OneToMany(mappedBy = "paciente")
//    @Column(name = "triagem_paciente")
//    private List<Triagem> triagens;
    
    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

//    public List<Triagem> getTriagens() {
//        return triagens;
//    }
//
//    public void setTriagens(List<Triagem> triagens) {
//        this.triagens = triagens;
//    }
    
}