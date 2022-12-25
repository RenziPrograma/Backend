/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Service;

import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.renziportfolio.PortFolioDeRenzi.Security.Repository.iCustomerRepository;

/**
 *
 * @author redac
 */

@Service
@Transactional
public class CustomerService {
    @Autowired
    iCustomerRepository icustomerRepository;
    
    public Optional <Customer> getByCustomerName (String customerName){
        return icustomerRepository.findByCustomerName(customerName);
    }
    
    public boolean existsByCustomerName (String customerName){
        return icustomerRepository.existsByCustomerName(customerName);
    }

    public boolean existsByEmail (String email){
        return icustomerRepository.existsByEmail(email);
    }
    
    
    public void save (Customer customer){
        icustomerRepository.save(customer);
    }
    
}
