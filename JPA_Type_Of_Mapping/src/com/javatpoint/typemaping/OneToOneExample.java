
package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OneToOneExample {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shoumitro Roy");
        
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Dev Roy");
        
        em.persist(s1);
        em.persist(s2);
        
        Library b1 = new Library();
        b1.setId(100);
        b1.setBook("Data Structure");
        b1.setStd(s1);
        
        Library b2 = new Library();
        b2.setId(101);
        b2.setBook("DSMS");
        b2.setStd(s2);
        
        em.persist(b1);
        em.persist(b2);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();

    }
}
