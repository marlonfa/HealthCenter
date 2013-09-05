/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.enums;

/**
 *
 * @author marlon
 */
public enum MedicoEspecialidade {
    ACUPUNTURISTA("Acupunturista"),
    ALERGIOLOGISTA("Alergologista"),
    ANESTESIOLOGISTA("Anestesiologista"),
    CARDIOLOGISTA("Cardiologista"),
    CLINICO_GERAL("Clínico Geral"),
    DERMATOLOGISTA("Dermatologista"),
    ENDOCRINOLOGISTA("Endocrinologista"),
    GASTROENTEROLOGISTA("Gastroenterologista"),
    GERIATRA("Geriatra"),
    GINECOLOGISTA("Ginecologista"),
    HOMEOPATISITA("Homeopatista"),
    INFECTOLOGISTA("Infectologia"),
    MASTOLOGISTA("Mastologista"),
    MEDICO_TRABALHO("Médico do Trabalho"),
    NEUROCIRURGISTA("Neurocirurgista"),
    NEFROLOGISTA("Nefrologista"),
    NEUROLOGISTA("Neurologista"),
    OFTALMOLOGISTA("Oftalmologista"),
    ONCOLOGISTA("Oncologista"),
    ORTOPEDISTA("Ortopedista"),
    OTORRINOLARINGOLOGISTA("Otorrinolaringologista"),
    PEDIATRA("Pediatra"),
    PNEUMOLOGISTA("Pneumologista"),
    PSIQUIATRIA("Psiquiatra"),
    RADIOLOGISTA("Radiologista"),
    REUMATOLOGISTA("Reumatologista"),
    UROLOGISTA("Urologista");

    
    private String especialidade;
    
    private MedicoEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    public String getEspecialidade(){
        return this.especialidade;
    }
}
