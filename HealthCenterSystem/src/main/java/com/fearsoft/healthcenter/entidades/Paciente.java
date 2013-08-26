/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author marlon
 */
@Entity
/*
 * a anotação @DiscriminatorValue fornece o valor correspondente à entidades
 * desta classe. Dado que todos os objetos derivados de Pessoa serão armazenados
 * em uma única tabela
 */
@DiscriminatorValue("paciente")
public class Paciente extends Pessoa implements Serializable{
  
    @Column(length = 16, nullable = false)
    private String SUS;
    
    public String getSUS() {
        return SUS;
    }

    public void setSUS(String SUS) {
        this.SUS = SUS;
    }

    @Override
    public String toString() {
        return "Paciente{" + "SUS=" + SUS + '}';
    }
}