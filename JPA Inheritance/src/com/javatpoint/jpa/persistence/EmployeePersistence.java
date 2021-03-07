package com.javatpoint.jpa.persistence;

import com.javatpoint.jpa.inheritence.ActiveEmployee;
import com.javatpoint.jpa.inheritence.RetiredEmployee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeePersistence {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee_details");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        ActiveEmployee ae1 = new ActiveEmployee(30000f, 2, 100,"Rahim Hossain");
        ActiveEmployee ae2 = new ActiveEmployee(32000f, 3, 101,"Karim Hossain");
        
        RetiredEmployee re1 = new RetiredEmployee(3000, 103,"Raju mea");
        RetiredEmployee re2 = new RetiredEmployee(4000, 104,"Sumit Roy");
        
        em.persist(ae1);
        em.persist(ae2);
        
        em.persist(re1);
        em.persist(re2);

        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
