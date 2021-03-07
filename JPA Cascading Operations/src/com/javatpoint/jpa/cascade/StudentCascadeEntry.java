package com.javatpoint.jpa.cascade;

import com.javatpoint.jpa.student.StudentEntity;
import com.javatpoint.jpa.student.Subject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentCascadeEntry {
    
    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Student_details" );  
            
        EntityManager em = emf.createEntityManager( );  
        em.getTransaction().begin();  
        
        
        
        StudentEntity s1 = new StudentEntity();
        s1.setS_id(100);
        s1.setName("Shoumitro Roy");
        s1.setAge(22);
        
        Subject subj = new Subject(s1.getS_id(),80,"English");
        s1.setSubj(subj);
        
        
        StudentEntity s2 = new StudentEntity();
        s2.setS_id(101);
        s2.setName("Dev Roy");
        s2.setAge(24);
        
        Subject subj2 = new Subject(s2.getS_id(),90,"Math");
        s2.setSubj(subj2);
        
       // No need to perform persist operation separately for different entities.  
      // This 2 statement don't require for @OneToOne(cascade = CascadeType.PERSIST) from StudentEntity
//        em.persist(subj);
//        em.persist(subj2);
        
        em.persist(s1);
        em.persist(s2);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
