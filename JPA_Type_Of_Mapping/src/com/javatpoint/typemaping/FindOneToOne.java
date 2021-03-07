
package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FindOneToOne {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        
        Library b= em.find(Library.class, 100);
        
        System.out.println("Id : "+b.getId());
        System.out.println("Name : "+b.getBook());
        
        Student s = b.getStd();
        System.out.println("Id : "+s.getId());
        System.out.println("Name : "+s.getName());
       
       
    }
}



//        
//        Student s= em.find(Student.class, 1);
//        
//        System.out.println("Id : "+s.getId());
//        System.out.println("Name : "+s.getName());