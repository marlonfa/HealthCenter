package com.fearsoft.healthcenter.acoes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.fearsoft.healthcenter.entidades.Consulta;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */

@Entity
@Table(name="historico_clinico")
public class HistoricoClinico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "paciente_id", nullable = false)
    private Long idPaciente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="consulta_id", nullable = false)
    private Consulta consulta;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}