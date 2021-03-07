package com.javatpoint.jpa.inheritence;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class ActiveEmployee extends Employee implements Serializable{
    
    private float  salary;
    private int experience;

    public ActiveEmployee(float salary, int experience, int id, String name) {
        super(id, name);
        this.salary = salary;
        this.experience = experience;
    }

    public ActiveEmployee() {
        super();
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
   
    
    
}
