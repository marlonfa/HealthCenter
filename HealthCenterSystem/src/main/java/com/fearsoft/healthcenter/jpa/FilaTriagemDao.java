/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.acoes.FilaTriagem;
import com.fearsoft.healthcenter.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Eder Ferreira
 */
public class FilaTriagemDao extends AbstractDao<FilaTriagem>{

    public FilaTriagemDao() {
        super(FilaTriagem.class);
    }
    
    @Override
    public List<FilaTriagem>findCustom(Long id){   	
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        List<FilaTriagem>list = null;
        try{
            list = session.createCriteria(FilaTriagem.class).addOrder(Order.asc("dataTriagem")).list();
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
