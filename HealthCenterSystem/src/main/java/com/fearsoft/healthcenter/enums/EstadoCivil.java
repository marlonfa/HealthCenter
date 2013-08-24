/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.enums;

/**
 *
 * @author marlon
 */
public enum EstadoCivil {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    VIUVO("Viúvo(a)"),
    DIVORCIADO("Divorciado(a)");
    
    private String estadoCivil;
    
    private EstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
        
    public String getEstadoCivil(){
        return this.estadoCivil;
    }
}
