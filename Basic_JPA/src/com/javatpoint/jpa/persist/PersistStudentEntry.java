package com.javatpoint.jpa.persist;

import com.javatpoint.jpa.student.StudentEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistStudentEntry {  
      
    public static void main(String args[]) {  
		    
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         
         StudentEntity s1 = new StudentEntity();
         
         s1.setId(102);
         s1.setName("Ripon Roy");
         s1.setAge(23);
         
         em.persist(s1);
         
         em.getTransaction().commit();
         
         em.close();
         emf.close();      

    }  
}  
