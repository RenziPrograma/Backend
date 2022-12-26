/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.WorkExperience;
import com.renziportfolio.PortFolioDeRenzi.repository.WorkExpRepository;
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
public class WorkExperienceService {

    @Autowired
    WorkExpRepository workExpRepository;

    public List<WorkExperience> list() {
        return workExpRepository.findAll();
    }

    public Optional<WorkExperience> getOne(int id) {
        return workExpRepository.findById(id);
    }

    public Optional<WorkExperience> getBusinessName(String businessName) {
        return workExpRepository.findByBusinessName(businessName);
    }
    
    public void save(WorkExperience expe){
        workExpRepository.save(expe);
    }
    
    public void delete(int id){
        workExpRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return workExpRepository.existsById(id);
    }
    
    public boolean existsByBusinessName(String businessName){
        return workExpRepository.existsBybusinessName(businessName);
    }
}
