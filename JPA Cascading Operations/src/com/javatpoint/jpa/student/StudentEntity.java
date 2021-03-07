package com.javatpoint.jpa.student;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//Student_details
@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {
    
    @Id
    private  int s_id;
    private String name;
    private int age;

  // CascadeType.REMOVE: In this cascade operation, if the parent entity is removed then all its 
  // related entity will also be removed.

  // CascadeType.PERSIST : In this cascade operation, if the parent entity is persisted then all its 
  // related entity will also be persisted.

//    @OneToOne
//    @OneToOne(cascade={CascadeType.REMOVE}) 
    @OneToOne(cascade = CascadeType.PERSIST)
    private Subject subj;

    public StudentEntity(int s_id, String name, int age, Subject subj) {
        super();
        this.s_id = s_id;
        this.name = name;
        this.age = age;
        this.subj = subj;
    }

    public StudentEntity() {
        super();
    }
    

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subject getSubj() {
        return subj;
    }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }
    
    
}
