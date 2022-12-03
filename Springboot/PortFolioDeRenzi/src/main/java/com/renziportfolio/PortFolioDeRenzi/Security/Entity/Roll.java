
package com.renziportfolio.PortFolioDeRenzi.Security.Entity;

import com.renziportfolio.PortFolioDeRenzi.Security.Enums.RollName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
    private RollName rollName;
    
    //*************constructor****************

    public Roll() {
    }

    public Roll(RollName rollName) {
        this.rollName = rollName;
    }
    
        //*************GETTER Y SETTER****************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RollName getRollName() {
        return rollName;
    }

    public void setRollName(RollName rollName) {
        this.rollName = rollName;
    }



    
    
    
    
    
    
    
    
}

