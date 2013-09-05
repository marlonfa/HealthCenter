/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.enums;

/**
 *
 * @author marlon
 */
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");
    
    private String sexo;
    
    private Sexo(String sexo){
        this.sexo = sexo;
    }
        
    public String getSexo(){
        return this.sexo;
    }
}
