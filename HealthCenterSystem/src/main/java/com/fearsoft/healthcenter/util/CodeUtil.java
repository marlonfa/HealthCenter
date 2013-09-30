/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Eder Ferreira
 */
public class CodeUtil {

    public int calcularIdade(Date nascimento) {
        int idade = 0;

        Date atual = new Date();
        
        Calendar a = Calendar.getInstance();
        Calendar n = Calendar.getInstance();

        a.setTime(atual);
        n.setTime(nascimento);

        int ano_a = a.get(Calendar.YEAR);
        int ano_n = n.get(Calendar.YEAR);

        int mes_a = n.get(Calendar.MONTH);
        int mes_n = n.get(Calendar.MONTH);

        int dia_a = n.get(Calendar.DAY_OF_MONTH);
        int dia_n = n.get(Calendar.DAY_OF_MONTH);

        idade = ano_a - ano_n;

        if (mes_a < mes_n || ((mes_a == mes_n) && (dia_a < dia_n))) {
            --idade;
        }

        return idade;
    }
}
