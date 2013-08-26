/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.entidades;

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
@DiscriminatorValue("recepcionista")
public class Recepcionista extends Pessoa{
    
    @Column(length = 10, nullable = false, unique = true)
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Recepcionista{" + "login=" + login + '}';
    }
}
