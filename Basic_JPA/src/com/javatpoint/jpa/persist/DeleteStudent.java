/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javatpoint.jpa.persist;

import com.javatpoint.jpa.student.StudentEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DeleteStudent {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        StudentEntity s = em.find(StudentEntity.class, 102);

        em.remove(s);
       
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Delete Record Successfully.");
    }
    
    
}
