/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Service;


import com.renziportfolio.PortFolioDeRenzi.Security.Entity.MainCustomer;
import com.renziportfolio.PortFolioDeRenzi.Security.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author redac
 */



@Service 
public class CustomerDetailsServiceImpl implements UserDetailsService{
    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
        Customer customer=customerService.getByCustomerName(customerName).get();
        return MainCustomer.build(customer);
    }
    
    
    
}
