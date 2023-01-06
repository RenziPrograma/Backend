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
public class DtoProjectRepo {
    
    private int persona_id;
    @NotBlank
    private String name;
    @NotBlank
    private String link;
 
    private String img;
    @NotBlank
    private String description;  

    public DtoProjectRepo() {
    } 

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public DtoProjectRepo(int persona_id, String name, String link, String img, String description) {
        this.persona_id = persona_id;
        this.name = name;
        this.link = link;
        this.img = img;
        this.description = description;
    }
    
    
    
    
}
