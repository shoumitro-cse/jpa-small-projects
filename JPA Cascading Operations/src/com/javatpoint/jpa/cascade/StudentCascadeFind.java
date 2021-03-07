package com.javatpoint.jpa.cascade;

import com.javatpoint.jpa.student.StudentEntity;
import com.javatpoint.jpa.student.Subject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentCascadeFind {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details" );             
        EntityManager em = emf.createEntityManager( );  
        
        em.getTransaction().begin();  
        
        StudentEntity s1 =  em.find(StudentEntity.class, 100);
        
        System.out.println("Student Id  : "+s1.getS_id());
        System.out.println("Student Age  : "+s1.getAge());
        System.out.println("Student Name  : "+s1.getName());
        
        System.out.println("........Student Subject .....");
        
         Subject subj = s1.getSubj();
         System.out.println("Subject Id  : "+subj.getS_id());
         System.out.println("Subject Marks : "+subj.getMarks());
         System.out.println("Subject Name  : "+subj.getName());
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
