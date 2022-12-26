/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.Dto.DtoEducation;
import com.renziportfolio.PortFolioDeRenzi.Entity.Education;
import com.renziportfolio.PortFolioDeRenzi.Security.Controller.Msj;
import com.renziportfolio.PortFolioDeRenzi.service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = "Http://localhost:4200")
public class EducationController {

    @Autowired
    EducationService educationService;

    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id")int id){
        if (!educationService.existsById(id)){
            return new ResponseEntity(new Msj("Error, no existe el id"), HttpStatus.NOT_FOUND);
        }
        Education education=educationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK); 
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, el ID no existe"), HttpStatus.NOT_FOUND);
        }
        educationService.delete(id);
        return new ResponseEntity(new Msj("Educación eliminada correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEducation) {
        if (StringUtils.isBlank(dtoEducation.getSchoolName())) {
            return new ResponseEntity(new Msj("Error, el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (educationService.existsBySchoolName(dtoEducation.getSchoolName())) {
            return new ResponseEntity(new Msj("Error, ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education education = new Education(
                dtoEducation.getPersona_id(),
                dtoEducation.getSchoolName(),
                dtoEducation.getDegree(),
                dtoEducation.getStartDate(),
                dtoEducation.getEndDate(),
                dtoEducation.getDescription());
        educationService.save(education);
        return new ResponseEntity(new Msj("Educación guardada exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoEducation) {
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (educationService.existsBySchoolName(dtoEducation.getSchoolName()) && educationService.getBySchoolName(dtoEducation.getSchoolName()).get().getId() != id) {
            return new ResponseEntity(new Msj("Esa Educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducation.getSchoolName())) {
            return new ResponseEntity(new Msj("El nombre de la educación no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Education education = educationService.getOne(id).get();
        
        education.setPersona_id(dtoEducation.getPersona_id());
        education.setSchoolName(dtoEducation.getSchoolName());
        education.setDegree(dtoEducation.getDegree());
        education.setStartDate(dtoEducation.getStartDate());
        education.setEndDate(dtoEducation.getEndDate());
        education.setDescription(dtoEducation.getDescription());
        
        educationService.save(education);
        return new ResponseEntity(new Msj("Educación actualizada exitosamente"), HttpStatus.OK);
    }
}
