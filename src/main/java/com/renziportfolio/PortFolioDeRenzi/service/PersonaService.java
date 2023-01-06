/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.Persona;
import com.renziportfolio.PortFolioDeRenzi.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author redac
 */

@Service
@Transactional
public class PersonaService  {
    
    @Autowired
    public PersonaRepository personaRepository;
    
    public List <Persona> list(){
        return personaRepository.findAll();
    }
    
   
    public Optional<Persona>getOne(int id){
        return personaRepository.findById(id);
    }
    
    public Optional<Persona> getByName(String Name){
        return personaRepository.findByName(Name);
    }
    
    public void save (Persona persona){
        personaRepository.save(persona);
    }
    
    public void delete (int id){
        personaRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
       return personaRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return personaRepository.existsByName(name);
    }
    
    
    
}
