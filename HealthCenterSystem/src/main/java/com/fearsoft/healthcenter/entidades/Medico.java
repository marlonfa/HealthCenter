/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import com.fearsoft.healthcenter.enums.MedicoEspecialidade;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
@DiscriminatorValue("medico")
public class Medico extends Pessoa implements Serializable {
    
    @Column(name = "crm", length = 20, nullable = false)
    private String crm;
    
    @Column(name = "especialidade", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MedicoEspecialidade especialidade;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public MedicoEspecialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(MedicoEspecialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" + "crm=" + crm + ", especialidade=" + especialidade + '}';
    }
    
    
}
