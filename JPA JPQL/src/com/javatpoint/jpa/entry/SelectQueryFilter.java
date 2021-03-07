package com.javatpoint.jpa.entry;

import com.javatpoint.jpa.StudentEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectQueryFilter {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Query query= em.createQuery("Select s from StudentEntity s where s.age between 22 and 23");
        // Query query= em.createQuery("Select s from StudentEntity s where s.id in(100,101)");
        Query query = em.createQuery("Select s from StudentEntity s where s.name like '%ri%' ");

        @SuppressWarnings("unchecked")
        List<StudentEntity> list = query.getResultList();

        System.out.println("    Student Record");
        System.out.println("...................");
        System.out.println("Id       Name       Age");
        System.out.println("...................");
        for (StudentEntity name : list) {
            System.out.println(name.getId() + "  " + name.getName() + "   " + name.getAge());
            System.out.println("...................");
        }

        em.close();
        emf.close();
    }
}
