/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author redac
 */
public class CustomerLogin {
    
    @NotBlank
    private String CustomerName;
    @NotBlank
    private String password;
    
    //////* Getter & SetterS

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
