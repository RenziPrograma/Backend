/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.repository;

import com.renziportfolio.PortFolioDeRenzi.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
