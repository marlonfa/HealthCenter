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
    
    public Object find(E id);
    public List findAll();
    public List findFilter(String parametro, E valor);
    public void createOrSave(E object);
    public void delete(E object);
}
