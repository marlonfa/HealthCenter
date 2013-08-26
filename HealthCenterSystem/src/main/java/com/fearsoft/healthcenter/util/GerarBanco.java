/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.util;

import com.fearsoft.healthcenter.entidades.Contato;
import com.fearsoft.healthcenter.entidades.Endereco;
import com.fearsoft.healthcenter.entidades.Medico;
import com.fearsoft.healthcenter.enums.EstadoCivil;
import com.fearsoft.healthcenter.enums.Sexo;
import com.fearsoft.healthcenter.jpa.MedicoDao;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author Eder Ferreira
 */
public class GerarBanco {
 
    public static void main(String[] args) {
        
//        System.out.println("Anter de Abrir Sessao");
//        HibernateUtil.getSessionFactory().openSession();
//        System.out.println("Depois de Abrir Sessao");
//        HibernateUtil.getSessionFactory().close();
//        System.out.println("Depois de Fechar Sessao");

        MedicoDao dao = new MedicoDao();
        
        Medico m = new Medico();
        Contato c = new Contato();
        Endereco e = new Endereco();
        
        c.setCelular("4411223344");
        c.setEmail("eder.esf92@gmail.com");
        c.setTelefone("4433223322");
        
        e.setBairro("Centro");
        e.setCep("86950000");
        e.setCidade("Fenix");
        e.setComplemento("Perto do Cemiterio");
        e.setNumero(243);
        e.setNomeEndereço("Rua rui barbosa");
        
        m.setNome("eder");
        m.setNaturalidade("brasileira");
        m.setDataNascimento(Calendar.getInstance().getTime());
        m.setSexo(Sexo.MASCULINO);
        m.setCpf("12345678901");
        m.setRg("1234567");
        m.setEstadoCivil(EstadoCivil.SOLTEIRO);
        m.setSenha("123");
        m.setContato(c);
        m.setEndereco(e);
        m.setCrm("12345");
        m.setEspecialidade("Cirurgiao geral");
        
        dao.persist(m);
    }
    
}
