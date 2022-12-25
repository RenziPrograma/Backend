/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author redac
 */
public class DtoPersona {

    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String position;
    @NotBlank
    private String base;
    @NotBlank
    private String email;
    @NotBlank
    private String telephone;
    @NotBlank
    private String profileImageUrl;
    @NotBlank
    private String representativeImageUrl;
    @NotBlank
    private String description;

    public DtoPersona() {
    }

    public DtoPersona(int id, String name, String surname, String position, String base, String email, String telephone, String profileImageUrl, String representativeImageUrl, String description) {
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

    public String getRepresentativeImageUrl() {
        return representativeImageUrl;
    }

    public void setRepresentativeImageUrl(String representativeImageUrl) {
        this.representativeImageUrl = representativeImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
