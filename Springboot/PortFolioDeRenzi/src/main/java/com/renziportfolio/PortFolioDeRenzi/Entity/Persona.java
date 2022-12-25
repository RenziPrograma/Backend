/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


/**
 *
 *aca van todas las clases 
 */
@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String position;
    @NotNull
    private String base;    
    @NotNull
    private String email;
    @NotNull
    private String telephone;
    @NotNull
    private String profileImageUrl;
    @NotNull
    private String representativeImageUrl;
    @NotNull
    private String description;
    
    public Persona(){
    }

    public Persona(int id, String name, String surname, String position, String base, String email, String telephone, String profileImageUrl, String representativeImageUrl, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.base = base;
        this.email = email;
        this.telephone = telephone;
        this.profileImageUrl = profileImageUrl;
        this.representativeImageUrl = representativeImageUrl;
        this.description = description;
    }

    

    
    
    
}

