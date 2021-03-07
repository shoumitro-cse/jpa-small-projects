package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OnToManyExample {
    
    public static void main(String[] args) {
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Library b1 = new Library();
        b1.setBook("Data Structure");
        b1.setId(100);
        
        Library b2 = new Library();
        b2.setBook("DBMS");
        b2.setId(101);
        
        em.persist(b1);
        em.persist(b2);
        
        List<Library> list = new ArrayList<Library>();
        
        list.add(b1);
        list.add(b2);
        
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Shoumitro Roy");
        s1.setBook_list(list);
        
        em.persist(s1);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
 
}
