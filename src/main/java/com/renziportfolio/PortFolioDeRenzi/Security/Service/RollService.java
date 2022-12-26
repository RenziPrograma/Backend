/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Service;

import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Roll;
import com.renziportfolio.PortFolioDeRenzi.Security.Enums.RollName;
import com.renziportfolio.PortFolioDeRenzi.Security.Repository.iRollRepository;
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
public class RollService {
    @Autowired
    iRollRepository irollRepository;
    
    public Optional <Roll> getByRollName (RollName rollName){
        return irollRepository.findByRollName(rollName);
    }
    
    
    public void save (Roll roll){
        irollRepository.save (roll);
    }
    
    
}
