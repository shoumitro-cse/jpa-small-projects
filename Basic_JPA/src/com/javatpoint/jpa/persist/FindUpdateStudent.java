package com.javatpoint.jpa.persist;

import com.javatpoint.jpa.student.StudentEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindUpdateStudent {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em1 = emf1.createEntityManager();
         
        StudentEntity s= em1.find(StudentEntity.class, 102);
        
        System.out.println("Id : "+s.getId());
        System.out.println("Name : "+s.getName());
        System.out.println("Age : "+s.getAge());
        
        System.out.println("Update Record.");
        
        s.setId(103);
        
        System.out.println("Id : "+s.getId());
        System.out.println("Name : "+s.getName());
        System.out.println("Age : "+s.getAge());
    }
}
