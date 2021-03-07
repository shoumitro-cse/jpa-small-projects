package com.javatpoint.jpa.student;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    
    @Id
    private  int s_id; 
    private int marks;
    private String name;

    public Subject() {
        super();
    }
    
    public Subject(int s_id, int marks, String name) {
        super();
        this.s_id = s_id;
        this.marks = marks;
        this.name = name;
    }

    
    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
