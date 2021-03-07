package com.javatpoint.collection;

import com.javatpoint.jpa.Address;
import com.javatpoint.jpa.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployee {
   
    public static void main(String[] args) {
               
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("Collection_Type");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Employee e = em.find(Employee.class, 1);
        
        System.out.println("Id : "+e.getId());
        System.out.println("Name : "+e.getName());
        
        List<Address> addrList = e.getAddress();
        
        System.out.println("\n\nGet Address Of Employee\n..................");
        for(Address addr : addrList) {
            
            System.out.println("Pincode : "+addr.getPincode()); 
            System.out.println("City : "+addr.getCity()); 
            System.out.println("State : "+addr.getState()); 
        }
        System.out.println("..................");
    }
}
