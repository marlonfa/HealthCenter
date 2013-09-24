/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.acoes;

import com.fearsoft.healthcenter.entidades.Triagem;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="fila_consulta")
public class FilaConsulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "username_medico")
    private String usernameMedico;
    
    @OneToOne()
    @JoinColumn(name = "triagem", nullable = false)
    private Triagem triagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernameMedico() {
        return usernameMedico;
    }

    public void setUsernameMedico(String usernameMedico) {
        this.usernameMedico = usernameMedico;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }
}