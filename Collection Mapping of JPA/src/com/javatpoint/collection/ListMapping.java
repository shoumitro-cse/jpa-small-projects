package com.javatpoint.collection;

import com.javatpoint.jpa.Address;
import com.javatpoint.jpa.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ListMapping {
   
    public static void main(String[] args) {
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Address a1 = new Address();
        a1.setCity("Jessore");
        a1.setPincode(1000);
        a1.setState("R.K");
        
        Address a2 = new Address();
        a2.setCity("Dkaka");
        a2.setPincode(1001);
        a2.setState("R.P Banani");
        
        Address a3 = new Address();
        a3.setCity("Khulna");
        a3.setPincode(1002);
        a3.setState("R.D Road Khulna");
        
        
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Shoumitro Roy");
        e1.getAddress().add(a1);
        
        
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Dev Roy");
        e2.getAddress().add(a2);
        
        Employee e3 = new Employee();
        e3.setId(3);
        e3.setName("Farjana Khatun");
        e3.getAddress().add(a3);
        
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        System.out.println("Record Entity Successfully.");
    }
}
