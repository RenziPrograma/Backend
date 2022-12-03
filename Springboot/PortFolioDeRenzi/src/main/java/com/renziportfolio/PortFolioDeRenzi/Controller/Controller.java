/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.model.Persona;
import com.renziportfolio.PortFolioDeRenzi.service.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author redac
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new/persona")
    public void agregarPersona (@RequestBody Persona pers){
       persoServ.crearPersona(pers);
    }
    
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
            return persoServ.verPersona();
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable long id){
        persoServ.borrarPersona(id);
    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/personas/{id}")
    public Persona editarPersona(@PathVariable long id,
                              @RequestParam("name") String newName,
                              @RequestParam("surname") String newSurname     
                              ){
        Persona pers=persoServ.buscarPersona(id);
        
        pers.setName(newName);
        pers.setSurname(newSurname);
        
        persoServ.crearPersona(pers);
        return pers;
        
    }
    
    @GetMapping("/buscar/persona")
    public Persona buscarPersona(){
        return persoServ.buscarPersona((long) 1);
    }
    
    /***localhost:8080/chau?nombre=Renzi&apellido=Colo Poss&edad=35*/
}
