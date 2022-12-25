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
public class DtoWorkExperience {
    private int persona_id;
    @NotBlank
    private String businessName;
    @NotBlank
    private String position;
    private String startDate;
    private String endDate;
    private String currentJob;
    @NotBlank
    private String description;

    
    //Constructores
    public DtoWorkExperience() {
    }

    public DtoWorkExperience(int persona_id, String businessName, String position, String startDate, String endDate, String currentJob, String description) {
        this.persona_id = persona_id;
        this.businessName = businessName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentJob = currentJob;
        this.description = description;
    }


    
    //Getters && Setters

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

}
