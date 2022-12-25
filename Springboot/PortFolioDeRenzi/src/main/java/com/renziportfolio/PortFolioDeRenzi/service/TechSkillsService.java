/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.service;

import com.renziportfolio.PortFolioDeRenzi.Entity.TechSkills;
import com.renziportfolio.PortFolioDeRenzi.repository.TechSkillRepository;
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
public class TechSkillsService {

    @Autowired
    TechSkillRepository techSkillRepository;

    public List<TechSkills> list() {
        return techSkillRepository.findAll();
    }
    
    public Optional <TechSkills> getOne(int id){
        return techSkillRepository.findById(id);
    }
    
    public Optional <TechSkills> getBySkillName( String skillName){
        return techSkillRepository.findBySkillName(skillName);
    }
    
    public void save (TechSkills skill){
        techSkillRepository.save(skill);
    }
    
    public void delete(int id){
        techSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return techSkillRepository.existsById(id);
    }
    
    public boolean existsBySkillName(String skillName){
        return techSkillRepository.existsBySkillName(skillName);
    }
}
