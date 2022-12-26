/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.Persona;
import java.util.List;

/**
 *
 * @author redac
 */
public interface IPersonaService {
    
        
    public List <Persona> verPersona();
    
    public void crearPersona(Persona Per);
    
    public void borrarPersona (Long id);
    
    public Persona buscarPersona (Long id);
    
}
