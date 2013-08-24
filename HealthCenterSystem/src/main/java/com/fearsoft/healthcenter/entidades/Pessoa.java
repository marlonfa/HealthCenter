/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author marlon
 */
public abstract class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "naturalidade", length = 30)
    private String naturalidade;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataNascimento", length = 8, nullable = false)
    private Date dataNascimento;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 9, nullable = false)
    private Sexo sexo;
    
    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;
    
    @Column(name = "rg",length = 9, nullable = false)
    private String rg;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoCivil", length = 20, nullable = false)
    private EstadoCivil estadoCivil;
    
    @Column(name = "senha", length = 6)
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", naturalidade=" + naturalidade + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", rg=" + rg + ", estadoCivil=" + estadoCivil + ", senha=" + senha + '}';
    }
}
