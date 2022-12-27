/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.Dto.DtoWorkExperience;
import com.renziportfolio.PortFolioDeRenzi.Entity.WorkExperience;

import com.renziportfolio.PortFolioDeRenzi.Security.Controller.Msj;
import com.renziportfolio.PortFolioDeRenzi.service.WorkExperienceService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://frontendrenziprograma.web.app")
public class WorkExperienceController {

    @Autowired
    WorkExperienceService workExperienceService;

    @GetMapping("/lista")
    public ResponseEntity<List<WorkExperience>> list() {
        List<WorkExperience> list = workExperienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<WorkExperience> getById(@PathVariable("id") int id) {
        if (!workExperienceService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, no existe el id"), HttpStatus.NOT_FOUND);
        }
        WorkExperience workExperience = workExperienceService.getOne(id).get();
        return new ResponseEntity(workExperience, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoWorkExperience dtoexp) {
        if (StringUtils.isBlank(dtoexp.getBusinessName())) {
            return new ResponseEntity(new Msj("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (workExperienceService.existsByBusinessName(dtoexp.getBusinessName())) {
            return new ResponseEntity(new Msj("Esa experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        }

        WorkExperience workExperience = new WorkExperience(
                dtoexp.getPersona_id(),
                dtoexp.getBusinessName(),
                dtoexp.getPosition(),
                dtoexp.getStartDate(),
                dtoexp.getEndDate(),
                dtoexp.getCurrentJob(),
                dtoexp.getDescription());
        workExperienceService.save(workExperience);

        return new ResponseEntity(new Msj("Experiencia agregada exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoWorkExperience dtoexp) {
        //valida si existe el id
        if (!workExperienceService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (workExperienceService.existsByBusinessName(dtoexp.getBusinessName()) && workExperienceService.getBusinessName(dtoexp.getBusinessName()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa experience ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoexp.getBusinessName())) {
            return new ResponseEntity(new Msj("El nombre de la experiencia no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        WorkExperience workExperience = workExperienceService.getOne(id).get();
        workExperience.setPersona_id(dtoexp.getPersona_id());
        workExperience.setBusinessName(dtoexp.getBusinessName());
        workExperience.setPosition(dtoexp.getPosition());
        workExperience.setStartDate(dtoexp.getStartDate());
        workExperience.setEndDate(dtoexp.getEndDate());
        workExperience.setCurrentJob(dtoexp.getCurrentJob());
        workExperience.setDescription(dtoexp.getDescription());

        workExperienceService.save(workExperience);
        return new ResponseEntity(new Msj("Experiencia actualizada"), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!workExperienceService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        workExperienceService.delete(id);

        return new ResponseEntity(new Msj("experiencia eliminada exitosamente"), HttpStatus.OK);
    }

}
