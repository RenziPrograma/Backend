/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Repository;

import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Roll;
import com.renziportfolio.PortFolioDeRenzi.Security.Enums.RollName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */

@Repository
public interface iRollRepository extends JpaRepository<Roll, Integer>{
    Optional<Roll> findByRollName (RollName rollName);
}
