/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author suse
 */
public class FindManyToOn {
    public static void main(String[] args) {
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        
        Student b= em.find(Student.class, 100);
        
        System.out.println("Id : "+b.getId());
        System.out.println("Name : "+b.getName());
        
        Library lib = b.getLib();
        System.out.println("\n\nBook Name and Id :\n................ ");
        System.out.println("Book : "+lib.getId());
        System.out.println("Book : "+lib.getBook());
      
//        Library lb= em.find(Library.class, 1);
//        
//        System.out.println("Id : "+lb.getId());
//        System.out.println("Name : "+lb.getBook());
 
    }
}
