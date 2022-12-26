/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Dto;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author redac
 */
public class NewCustomer {

    private String name;
    private String CustomerName;
    private String email;
    private String password;
    private  Set<String> rolls= new HashSet<>();
    
    
    //******Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRolls() {
        return rolls;
    }

    public void setRolls(Set<String> rolls) {
        this.rolls = rolls;
    }

    
    
}
