/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.repository;

import com.renziportfolio.PortFolioDeRenzi.Entity.WorkExperience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */

@Repository
public interface WorkExpRepository extends JpaRepository<WorkExperience, Integer>{
    public Optional<WorkExperience> findByBusinessName(String businessName);
    public boolean existsBybusinessName(String businessName);
}
