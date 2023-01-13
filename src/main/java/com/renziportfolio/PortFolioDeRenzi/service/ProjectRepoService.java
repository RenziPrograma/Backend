/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.ProjectRepo;
import com.renziportfolio.PortFolioDeRenzi.repository.ProjectRepoRepository;
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
public class ProjectRepoService {

    @Autowired
    ProjectRepoRepository projectRepoRepository;

    public List<ProjectRepo> list() {
        return projectRepoRepository.findAll();
    }

    public Optional<ProjectRepo> getOne(int id) {
        return projectRepoRepository.findById(id);
    }
    
    public Optional<ProjectRepo> getByName(String name){
        return projectRepoRepository.findByName(name);
    }
    
    public void save (ProjectRepo project){
        projectRepoRepository.save(project);
    }
    
    public void delete(int id){
        projectRepoRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
       return projectRepoRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return projectRepoRepository.existsByName(name);
    }
    
}
