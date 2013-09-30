/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fearsoft.healthcenter.controladores;

import java.util.List;

/**
 *
 * @author marlon
 */
public interface InterfaceControle <E>{
    
    public Object find(Long id);
    public List findAll();
    public List findFilter(String parametro, Object valor);
    public void saveOrUpdate(E object);
    public void delete(E object);
}
