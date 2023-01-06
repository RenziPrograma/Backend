/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.repository;

import com.renziportfolio.PortFolioDeRenzi.Entity.ProjectRepo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */
@Repository
public interface ProjectRepoRepository extends JpaRepository<ProjectRepo, Integer> {

    Optional<ProjectRepo> findByName(String name);

    public boolean existsByName(String name);
}
