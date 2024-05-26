/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.dao;

import java.util.List;

/**
 *
 * @author soporte
 */
public interface Contrato<Cualquiercosa> {

    boolean create(Cualquiercosa nuevo);

    public boolean delete(Object item);

    public boolean update(Cualquiercosa filter);
    
    public Cualquiercosa read(Cualquiercosa filter);

    public List<Cualquiercosa> readAll();
    
}
