/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;


import com.renziportfolio.PortFolioDeRenzi.Dto.DtoTechSkills;
import com.renziportfolio.PortFolioDeRenzi.Entity.TechSkills;
import com.renziportfolio.PortFolioDeRenzi.Security.Controller.Msj;
import com.renziportfolio.PortFolioDeRenzi.service.TechSkillsService;
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
 */
@RestController
@RequestMapping("/techSkills")
@CrossOrigin(origins = "Http://localhost:4200")
public class TechSkillController {
    
    @Autowired
    TechSkillsService techSkillsService;
    

    @GetMapping("/lista")
    public ResponseEntity<List<TechSkills>> list() {
        List<TechSkills> list = techSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TechSkills> getById(@PathVariable("id") int id) {
        if (!techSkillsService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, no existe el id"), HttpStatus.NOT_FOUND);
        }
        TechSkills techSkills = techSkillsService.getOne(id).get();
        return new ResponseEntity(techSkills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!techSkillsService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, el ID no existe"), HttpStatus.NOT_FOUND);
        }
        techSkillsService.delete(id);
        return new ResponseEntity(new Msj("Habilidad eliminada correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoTechSkills dtoTechSkills) {
        if (StringUtils.isBlank(dtoTechSkills.getSkillName())) {
            return new ResponseEntity(new Msj("Error, el nombre de la habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (techSkillsService.existsBySkillName(dtoTechSkills.getSkillName())) {
            return new ResponseEntity(new Msj("Error, esta habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        TechSkills techSkills = new TechSkills(
                dtoTechSkills.getPersona_id(),
                dtoTechSkills.getSkillName(),
                dtoTechSkills.getSkillLevel());
        techSkillsService.save(techSkills);
        return new ResponseEntity(new Msj("Habilidad guardada exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoTechSkills dtoTechSkills) {
        if (!techSkillsService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (techSkillsService.existsBySkillName(dtoTechSkills.getSkillName()) && techSkillsService.getBySkillName(dtoTechSkills.getSkillName()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoTechSkills.getSkillName())) {
            return new ResponseEntity(new Msj("El nombre de la habildiad no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        TechSkills techSkills = techSkillsService.getOne(id).get();

        techSkills.setPersona_id(dtoTechSkills.getPersona_id());
        techSkills.setSkillName(dtoTechSkills.getSkillName());
        techSkills.setSkillLevel(dtoTechSkills.getSkillLevel());

        techSkillsService.save(techSkills);
        return new ResponseEntity(new Msj("Habilidad actualizada exitosamente"), HttpStatus.OK);
    }
}
