package com.javatpoint.jpa.entry;

import com.javatpoint.jpa.StudentEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateQuery {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("update StudentEntity set name='Shoumitro Roy' where id=100 ");
        query.executeUpdate();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
