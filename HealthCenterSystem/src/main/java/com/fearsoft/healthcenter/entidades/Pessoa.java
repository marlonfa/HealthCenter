/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "pessoa")

/*
 * A anotação @Inheritance estabelece a estratégia a ser empregada.
 * Neste caso, uma única tabela será empregada para 
 * registrar toda e qualquer instância derivada de Pessoa
 */
@Inheritance(strategy = InheritanceType.JOINED)
/*
 * A anotação @Discrimnator estabelece como será feita a distinção
 * entre registros armazenados nesta única tabela de tal forma que seja
 * possível estabelecer quais campos foram empregados (um subconjunto
 * dos campos para cada subclasse).
 */
@DiscriminatorColumn(name = "tipo")
public abstract class Pessoa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "naturalidade", length = 30, nullable = false)
    private String naturalidade;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", length = 8, nullable = false)
    private Date dataNascimento;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 9, nullable = false)
    private Sexo sexo;
    
    @Column(name = "cpf", unique = true, length = 11, nullable = false)
    private String cpf;
    
    @Column(name = "rg",length = 9, nullable = false)
    private String rg;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil", length = 20, nullable = false)
    private EstadoCivil estadoCivil;
    
    @JoinColumn(name = "contato")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Contato contato;
    
    @JoinColumn(name = "endereco")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;
    
    @JoinColumn(name = "users")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;
    
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", naturalidade=" + naturalidade + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cpf=" + cpf + ", rg=" + rg + ", estadoCivil=" + estadoCivil + ", contato=" + contato + ", endereco=" + endereco + ", usuario=" + usuario + '}';
    }
}