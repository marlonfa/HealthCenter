/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.acoes.FilaConsulta;
import com.fearsoft.healthcenter.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eder Ferreira
 */
public class FilaConsultaDao extends AbstractDao<FilaConsulta> {

    public FilaConsultaDao() {
        super(FilaConsulta.class);
    }

    public List<FilaConsulta> findConsultas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (session.beginTransaction() == null) {
            session.beginTransaction();
        }
        List<FilaConsulta> list = null;
        try {
            list = session.createCriteria(FilaConsulta.class).addOrder(Order.asc("id")).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Buscar " + e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }
}
