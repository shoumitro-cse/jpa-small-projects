package com.javatpoint.jpa.persistence;

import com.javatpoint.jpa.inheritence.ActiveEmployee;
import com.javatpoint.jpa.inheritence.RetiredEmployee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EmployeeFind {
    
    public static void main(String[] args) {
                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee_details");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        ActiveEmployee ae = em.find(ActiveEmployee.class, 101);
        
        System.out.println("Employee Id  : "+ae.getId());
        System.out.println("Employee Name  : "+ae.getName());
        System.out.println("Employee Experience  : "+ae.getExperience());
        System.out.println("Employee Salary  : "+ae.getSalary());
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
