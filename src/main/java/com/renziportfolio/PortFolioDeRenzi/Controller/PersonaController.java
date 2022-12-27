/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.Dto.DtoPersona;
import com.renziportfolio.PortFolioDeRenzi.Entity.Persona;
import com.renziportfolio.PortFolioDeRenzi.Security.Controller.Msj;
import com.renziportfolio.PortFolioDeRenzi.service.PersonaService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author redac
 *
 */
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendrenziprograma.web.app")

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, no existe el id"), HttpStatus.NOT_FOUND);
        }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, el ID no existe"), HttpStatus.NOT_FOUND);
        }
        personaService.delete(id);
        return new ResponseEntity(new Msj("Educación eliminada correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
        if (StringUtils.isBlank(dtoPersona.getName())) {
            return new ResponseEntity(new Msj("Error, el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (personaService.existsBySchoolName(dtoPersona.getName())) {
            return new ResponseEntity(new Msj("Error, ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(
                dtoPersona.getId(),
                dtoPersona.getName(),
                dtoPersona.getSurname(),
                dtoPersona.getPosition(),
                dtoPersona.getBase(),
                dtoPersona.getEmail(),
                dtoPersona.getTelephone(),
                dtoPersona.getProfileImageUrl(),
                dtoPersona.getRepresentativeImageUrl(),
                dtoPersona.getDescription());
        personaService.save(persona);
        return new ResponseEntity(new Msj("Persona guardada exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (personaService.existsBySchoolName(dtoPersona.getName()) && personaService.getByName(dtoPersona.getName()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoPersona.getName())) {
            return new ResponseEntity(new Msj("El nombre de la Persona no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();

        persona.setId(dtoPersona.getId());
        persona.setName(dtoPersona.getName());
        persona.setSurname(dtoPersona.getSurname());
        persona.setPosition(dtoPersona.getPosition());
        persona.setBase(dtoPersona.getBase());
        persona.setEmail(dtoPersona.getEmail());
        persona.setTelephone(dtoPersona.getTelephone());
        persona.setProfileImageUrl(dtoPersona.getProfileImageUrl());
        persona.setRepresentativeImageUrl(dtoPersona.getRepresentativeImageUrl());
        persona.setDescription(dtoPersona.getDescription());

        personaService.save(persona);
        return new ResponseEntity(new Msj("Persona actualizada exitosamente"), HttpStatus.OK);
    }
}
