/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import com.fearsoft.healthcenter.enums.MedicoEspecialidade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */
@Entity
@Table(name = "medico")
public class Medico extends Pessoa implements Serializable {
    
    @Column(name = "crm", length = 20, nullable = false)
    private String crm;
    
    @Column(name = "especialidade", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MedicoEspecialidade especialidade;

//    @OneToMany(mappedBy = "medico")
//    @Column(name = "triagem_medico")
//    private List<Triagem> triagens;
    
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

//    public List<Triagem> getTriagens() {
//        return triagens;
//    }
//
//    public void setTriagens(List<Triagem> triagens) {
//        this.triagens = triagens;
//    }
    
}
