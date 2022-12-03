/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author redac
 */

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int id;
    @NotNull
    private String name;
    @NotNull
    @Column(unique=true)
    private String customerName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="customer_roll", joinColumns=@JoinColumn(name="customer_id"), inverseJoinColumns=@JoinColumn(name="roll_id"))
    private Set <Roll> rolls=new HashSet<>();
    
    //************CONSTRUCTORES**********

    public Customer() {
    }

    public Customer(String name, String customerName, String email, String password) {
        this.name = name;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }
    
    //***************GETTERS AND SETTERS***********

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Set<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(Set<Roll> rolls) {
        this.rolls = rolls;
    }



 
   
}
