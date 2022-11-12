/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.model.Persona;
import com.renziportfolio.PortFolioDeRenzi.service.IPersonaService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class Controller {
    
    @Autowired
    private IPersonaService persoServ;

    
    @PostMapping("/new/persona")
    public void agregarPersona (@RequestBody Persona pers){
       persoServ.crearPersona(pers);
    }
    
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
            return persoServ.verPersona();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable long id){
        persoServ.borrarPersona(id);
    
    }
    
    @PutMapping("/editar/personas/{id}")
    public Persona editarPersona(@PathVariable long id,
                              @RequestParam("nombre") String nuevoNombre,
                              @RequestParam("apellido") String nuevoApellido     
                              ){
        Persona pers=persoServ.buscarPersona(id);
        
        pers.setNombre(nuevoNombre);
        pers.setApellido(nuevoApellido);
        
        persoServ.crearPersona(pers);
        return pers;
        
    }
    
    
    /***localhost:8080/chau?nombre=Renzi&apellido=Colo Poss&edad=35*/
}
