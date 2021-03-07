package com.javatpoint.jpa.entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteQuery {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Query query = em.createQuery("Delete from StudentEntity where id >= 100 ");
        Query query = em.createQuery("Delete from StudentEntity where id = 103 ");
        query.executeUpdate();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
