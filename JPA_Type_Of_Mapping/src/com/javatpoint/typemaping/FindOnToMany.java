
package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindOnToMany {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        
        Student b= em.find(Student.class, 1);
        
        System.out.println("Id : "+b.getId());
        System.out.println("Name : "+b.getName());
        
        List<Library> s = b.getBook_list();
        
        System.out.println("\n\nBook Name and Id :\n................ ");
        for(Library LB : s) {
            System.out.println("Id : "+LB.getId());
            System.out.println("Name : "+LB.getBook());
        }
        
//        
//        Library Lib= em.find(Library.class, 100);
//        
//        System.out.println("Id : "+Lib.getId());
//        System.out.println("Name : "+Lib.getBook());
             
    }
}
