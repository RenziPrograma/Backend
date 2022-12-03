/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Repository;

import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author redac
 */

@Repository
public interface iCustomerRepository extends JpaRepository<Customer,Integer>{
    Optional<Customer> findByCustomerName(String customerName);
    
    boolean existsByCustomerName (String customerName);
    boolean existsByEmail (String email);
}
