/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package build_jpa;

import build_jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author shoumitro
 */
public class DataEntry {

    public static void main(String[] args) throws NonexistentEntityException, Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        StudentJpaController sc = new StudentJpaController(emf);

        Student student = new Student();
        student.setId(105);
        student.setFirstName("Farjana");
        student.setLastName("Begum");
        student.setAge(23);

        sc.create(student);// insert new record 

//      em.persist(student); // 2nd way insert new record 
//      sc.destroy(104);  // remove record from table

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
