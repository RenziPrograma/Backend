/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renziportfolio.PortFolioDeRenzi.Security.Entity;

import com.renziportfolio.PortFolioDeRenzi.Security.Enums.RollName;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author redac
 */

@Entity
public class Roll {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RollName rollname;
    
    //*************constructor****************

    public Roll() {
    }

    public Roll(RollName rollname) {
        this.rollname = rollname;
    }
    
        //*************GETTER Y SETTER****************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RollName getRollname() {
        return rollname;
    }

    public void setRollname(RollName rollname) {
        this.rollname = rollname;
    }



    
    
    
    
    
    
    
    
}

