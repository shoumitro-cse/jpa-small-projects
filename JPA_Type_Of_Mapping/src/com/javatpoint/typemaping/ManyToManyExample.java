/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author suse
 */
public class ManyToManyExample {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Student s1 = new Student();
        s1.setId(100);
        s1.setName("Shoumitro Roy");
        s1.setMlib(null);
        
        Student s2 = new Student();
        s2.setId(101);
        s2.setName("Dev Roy");
        s2.setMlib(null);
        
        em.persist(s1);
        em.persist(s2);
        
        List<Student> list = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        
        list.add(s1);
        list.add(s2);
        
        list2.add(s1);
        list2.add(s2);
        
        Library lib = new Library();
        lib.setBook("Data Structure");
        lib.setId(1);
        lib.setMstu(list);
        
        Library lib2 = new Library();
        lib2.setBook("DBMS");
        lib2.setId(2);
        lib2.setMstu(list2);
        
        em.persist(lib);
        em.persist(lib2);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
