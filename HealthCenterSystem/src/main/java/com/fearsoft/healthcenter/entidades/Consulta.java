/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "sintomas", nullable = false)
    private String sintomas;
    
    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;
    
    @Column(name = "prescricao", nullable = false)
    private String prescricao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "triagem_id")
    private Triagem triagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }
//
//    @Override
//    public String toString() {
//        return "Consulta{" + "id=" + id + ", sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", prescricao=" + prescricao + ", triagem=" + triagem + '}';
//    }
}