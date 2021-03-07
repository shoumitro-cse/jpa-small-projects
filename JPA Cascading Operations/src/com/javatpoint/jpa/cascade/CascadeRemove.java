
package com.javatpoint.jpa.cascade;

import com.javatpoint.jpa.student.StudentEntity;
import com.javatpoint.jpa.student.Subject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CascadeRemove {
    
    public static void main(String[] args) {
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Student_details" );             
        EntityManager em = emf.createEntityManager( );  
        
        em.getTransaction().begin();  
        
        StudentEntity s1 =  em.find(StudentEntity.class, 100);
        StudentEntity s2 =  em.find(StudentEntity.class, 101);
        
     //   Subject sbj = em.find(Subject.class, 100);
        //em.remove(sbj);
        
        
        em.remove(s1);
   //     em.remove(s2);
              
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
