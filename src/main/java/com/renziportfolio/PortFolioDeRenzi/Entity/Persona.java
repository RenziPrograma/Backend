
package com.renziportfolio.PortFolioDeRenzi.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 *
 *aca van todas las clases 
 */

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
    
    private String profileImageUrl;
    
    private String representaImg;
    @NotNull
    private String description;
    
    public Persona(){
    }

    public Persona(int id, String name, String surname, String position, String base, String email, String telephone, String profileImageUrl, String representaImg, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.base = base;
        this.email = email;
        this.telephone = telephone;
        this.profileImageUrl = profileImageUrl;
        this.representaImg = representaImg;
        this.description = description;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getRepresentaImg() {
        return representaImg;
    }

    public void setRepresentaImg(String representaImg) {
        this.representaImg = representaImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}

