/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.acoes.HistoricoClinico;
import com.fearsoft.healthcenter.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eder Ferreira
 */
public class HistoricoClinicoDao extends AbstractDao<HistoricoClinico>{

    public HistoricoClinicoDao() {
        super(HistoricoClinico.class);
    }
    
    
    @Override
    public List findCustom(Long id){   	
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        List list = null;
        try{
            list = session.createCriteria(HistoricoClinico.class).add(Restrictions.eq("idPaciente", id)).addOrder(Order.desc("id")).list();
            session.getTransaction().commit();            
        }catch(Exception e){
            System.out.println("Erro ao Buscar "+e);
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return list;
    }
}
