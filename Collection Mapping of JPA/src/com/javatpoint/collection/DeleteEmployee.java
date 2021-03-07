package com.javatpoint.collection;

import com.javatpoint.jpa.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteEmployee {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Employee e = em.find(Employee.class, 3);
        Employee e1 = em.find(Employee.class, 2);
        Employee e2 = em.find(Employee.class, 1);
              
        em.remove(e2);
        em.remove(e1);
        em.remove(e);

        em.getTransaction().commit();
        
        em.close();
        emf.close();
        System.out.println("Delete Successfully");
    }
}
