/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author marlon
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome_endereco", length = 60, nullable = false)
    private String nomeEndereço;
    
    @Column(length = 30)
    private String bairro;
    
    @Column(length = 6)
    private int numero;
    
    @Column(length = 30)
    private String complemento;
    
    @Column(length = 8, nullable = false)
    private String cep;
    
    @Column(length = 50, nullable = false)
    private String cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEndereço() {
        return nomeEndereço;
    }

    public void setNomeEndereço(String nomeEndereço) {
        this.nomeEndereço = nomeEndereço;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", nomeEndere\u00e7o=" + nomeEndereço + ", bairro=" + bairro + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", cidade=" + cidade + '}';
    }
}