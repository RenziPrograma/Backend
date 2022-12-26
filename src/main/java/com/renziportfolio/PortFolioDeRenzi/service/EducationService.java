/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.Education;
import com.renziportfolio.PortFolioDeRenzi.repository.EducationRepository;
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
public class EducationService {
    @Autowired
    EducationRepository educationRepository;
    
    public List <Education> list(){
        return educationRepository.findAll();
    }
    
    public Optional<Education>getOne(int id){
        return educationRepository.findById(id);
    }
    
    public Optional<Education> getBySchoolName(String schoolName){
        return educationRepository.findBySchoolName(schoolName);
    }
    
    public void save (Education education){
        educationRepository.save(education);
    }
    
    public void delete (int id){
        educationRepository.deleteById(id);
    }
    
    public boolean existsById (int id){
       return educationRepository.existsById(id);
    }
    
    public boolean existsBySchoolName(String SchoolName){
        return educationRepository.existsBySchoolName(SchoolName);
    }
    
}

