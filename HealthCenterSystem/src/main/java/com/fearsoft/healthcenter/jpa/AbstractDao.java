/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import com.fearsoft.healthcenter.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author marlon
 */
public abstract class AbstractDao<T> {
    private Class<T> entityClass;
   
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void saveOrUpdate(T object) {
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            session.saveOrUpdate(object);
            session.getTransaction().commit();
        }        
        catch(Exception e){
            System.out.println("Erro ao Persistir "+e);
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    public void delete(T object) {
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            session.delete(object);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Remover ERRO: "+ e);
            session.getTransaction().rollback();           
        }finally{
            session.close();
        }
    }  
    
    public List findFilter(String parametro, Object valor){
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            List lista = session.createCriteria(entityClass)
                    .add(Restrictions.like(parametro, "%"+valor+"%")).addOrder(Order.asc(parametro)).list();
            session.getTransaction().commit();
            return lista;
        }        
        catch(Exception e){
            System.out.println("Erro ao Buscar Filtrando "+e);
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return null;
    }
    
    public T find(Object id) {
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try {
            Object object = session.createCriteria(entityClass)
                    .add(Restrictions.eq("id", id)).list().get(0);
            session.getTransaction().commit();
            return (T) object;
        } catch (Exception e) {
            System.out.println("Erro ao Buscar pelo ID");
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return null;   
    }
        
    public List<T>findAll(){   	
        Session session = HibernateUtil.getInstance().openSession();
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        List<T>list = null;
        try{
            list = session.createCriteria(entityClass).list();
            session.getTransaction().commit();            
        }catch(Exception e){
            System.out.println("Erro ao Buscar "+e);
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return list;
    }
    
     public abstract List<T>findCustom(Long id);   
}
