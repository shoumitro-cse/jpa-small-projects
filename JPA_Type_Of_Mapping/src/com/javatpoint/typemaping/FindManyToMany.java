package com.javatpoint.typemaping;

import com.javatpoint.mapping.Library;
import com.javatpoint.mapping.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindManyToMany {
    
    public static void main(String[] args) {
                
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("Book_issued");
       EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Library lib = em.find(Library.class, 1);
        System.out.println("Id Name : "+lib.getId());
        System.out.println("Book Name : "+lib.getBook());
        
        List<Student> list = lib.getMstu();
        
        System.out.println("\n......Student Record.......");
        for(Student std : list){
            System.out.println("Student Name : "+std.getName());
            System.out.println("Id Name : "+std.getId());
          
        }
    }
}
