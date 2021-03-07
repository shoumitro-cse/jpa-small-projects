package com.javatpoint.jpa.entry;

import com.javatpoint.jpa.StudentEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRecordEnter {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        StudentEntity s = new StudentEntity(100, "Rahim Hossain", 23);
        StudentEntity s1 = new StudentEntity(101, "Korim Khan", 22);
        StudentEntity s2 = new StudentEntity(102, "Farjana Begum", 24);
        StudentEntity s3 = new StudentEntity(103, "Rahat Kabir", 25);

        em.persist(s);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
