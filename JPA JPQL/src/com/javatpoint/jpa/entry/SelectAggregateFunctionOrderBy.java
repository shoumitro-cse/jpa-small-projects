package com.javatpoint.jpa.entry;

import com.javatpoint.jpa.StudentEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SelectAggregateFunctionOrderBy {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query q1 = em.createQuery("Select count(s) from StudentEntity s");
        System.out.println("Number of Student : " + q1.getSingleResult());

        Query q2 = em.createQuery("Select max(s.age) from StudentEntity s");
        System.out.println("Max age of Student : " + q2.getSingleResult());

        Query q3 = em.createQuery("Select min(s.age) from StudentEntity s");
        System.out.println("min age of Student : " + q3.getSingleResult());

        // Sort data order by clause
        Query q4 = em.createQuery("Select s from StudentEntity s order by s.age desc");
        // Query q4 = em.createQuery("Select s from StudentEntity s order by s.name desc");
        @SuppressWarnings("unchecked")
        List<StudentEntity> list = q4.getResultList();

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
