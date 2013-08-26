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
@DiscriminatorValue("enfermeiro")
public class Enfermeiro extends Pessoa implements Serializable{
 
    @Column(length = 20, nullable = false)
    private String coren;
    
    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" + "coren=" + coren + '}';
    }
}