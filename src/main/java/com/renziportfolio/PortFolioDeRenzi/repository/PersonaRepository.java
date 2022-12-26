/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.repository;

import com.renziportfolio.PortFolioDeRenzi.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    public Optional<Persona> findByName(String Name);

    public boolean existsByName(String Name);
}
