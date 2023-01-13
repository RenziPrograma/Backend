/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Controller;

import com.renziportfolio.PortFolioDeRenzi.Dto.DtoProjectRepo;
import com.renziportfolio.PortFolioDeRenzi.Entity.ProjectRepo;
import com.renziportfolio.PortFolioDeRenzi.Security.Controller.Msj;
import com.renziportfolio.PortFolioDeRenzi.service.ProjectRepoService;
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
@RequestMapping("/projectRepo")
@CrossOrigin(origins = {"https://frontendrenziprograma.web.app", "http://localhost:4200"})
public class ProjectRepoController {

    @Autowired
    ProjectRepoService projectRepoService;

    @GetMapping("/lista")
    public ResponseEntity<List<ProjectRepo>> list() {
        List<ProjectRepo> list = projectRepoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ProjectRepo> getById(@PathVariable("id") int id) {
        if (!projectRepoService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, no existe el id"), HttpStatus.NOT_FOUND);
        }
        ProjectRepo projectRepo = projectRepoService.getOne(id).get();
        return new ResponseEntity(projectRepo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!projectRepoService.existsById(id)) {
            return new ResponseEntity(new Msj("Error, el ID no existe"), HttpStatus.NOT_FOUND);
        }
        projectRepoService.delete(id);
        return new ResponseEntity(new Msj("Proyecto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProjectRepo dtoProjectRepo) {
        if (StringUtils.isBlank(dtoProjectRepo.getName())) {
            return new ResponseEntity(new Msj("Error, el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (projectRepoService.existsByName(dtoProjectRepo.getName())) {
            return new ResponseEntity(new Msj("Error, ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        ProjectRepo projectRepo = new ProjectRepo(
                dtoProjectRepo.getPersona_id(),
                dtoProjectRepo.getName(),
                dtoProjectRepo.getLink(),
                dtoProjectRepo.getImg(),
                dtoProjectRepo.getDescription());
        projectRepoService.save(projectRepo);
        return new ResponseEntity(new Msj("Proyecto guardado exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProjectRepo dtoProjectRepo) {
        if (!projectRepoService.existsById(id)) {
            return new ResponseEntity(new Msj("El id no existe"), HttpStatus.NOT_FOUND);
        }
        if (projectRepoService.existsByName(dtoProjectRepo.getName()) && projectRepoService.getByName(dtoProjectRepo.getName()).get().getId() != id) {
            return new ResponseEntity(new Msj("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProjectRepo.getName())) {
            return new ResponseEntity(new Msj("El nombre del proyecto no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        ProjectRepo projectRepo = projectRepoService.getOne(id).get();

        projectRepo.setPersona_id(dtoProjectRepo.getPersona_id());
        projectRepo.setName(dtoProjectRepo.getName());
        projectRepo.setLink(dtoProjectRepo.getLink());
        projectRepo.setImg(dtoProjectRepo.getImg());
        projectRepo.setDescription(dtoProjectRepo.getDescription());

        projectRepoService.save(projectRepo);
        return new ResponseEntity(new Msj("Proyecto actualizado exitosamente"), HttpStatus.OK);
    }

}
