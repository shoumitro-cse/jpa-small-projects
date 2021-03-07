package com.javatpoint.jpa.inheritence;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class RetiredEmployee extends Employee implements Serializable {
    
    private float pension;

    public RetiredEmployee(float pension, int id, String name) {
        super(id, name);
        this.pension = pension;
    }

    public RetiredEmployee() {
        super();
    }

    public float getPension() {
        return pension;
    }

    public void setPension(float pension) {
        this.pension = pension;
    }
    
    
    
}
