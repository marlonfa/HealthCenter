/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.acoes;

import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.entidades.Paciente;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marlon
 */
@Entity
@Table(name="fila_triagem")
public class FilaTriagem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_triagem", nullable = false)
    private Date dataTriagem;

    @OneToOne()
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    
    @OneToOne()
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataTriagem() {
        return dataTriagem;
    }

    public void setDataTriagem(Date dataTriagem) {
        this.dataTriagem = dataTriagem;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

   
}
