/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.jpa;

import java.util.List;
/**
 *
 * @author marlon
 */
public abstract class AbstractDao<T> {
    private Class<T> entityClass;
   
    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void persist(T object) {
    }
    
    public void delete(T object) {
    }  
    
    public T find(Object id) {
        return null;   
    }
        
    public List<T>findAll(){   	
        return null;

    }
}
