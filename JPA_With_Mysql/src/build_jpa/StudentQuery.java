package build_jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentQuery {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Query query= em.createQuery("Select name from StudentEntity ");
        Query query = em.createQuery("Select s from Student s");
        // Query query= em.createNamedQuery("find name");

        @SuppressWarnings("unchecked")
        List<Student> list = query.getResultList();

        System.out.println("    Student Record");
        System.out.println("...................");
        System.out.println("Id          Name        Age");
        System.out.println("...................");

        for (Student name : list) {
            System.out.println(name.getId() + "       " + name.getFirstName() + " " + name.getLastName() + "     " + name.getAge());
            System.out.println("...................");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
