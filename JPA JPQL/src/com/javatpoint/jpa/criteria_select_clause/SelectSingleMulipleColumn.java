package com.javatpoint.jpa.criteria_select_clause;

import com.javatpoint.jpa.StudentEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SelectSingleMulipleColumn {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(StudentEntity.class);

        Root<StudentEntity> student = cq.from(StudentEntity.class);

        // cq.multiselect(student.get("name"), student.get("id"), student.get("age"));
//         cq.select(student.get("name"));
//         cq.orderBy(cb.desc(student.get("age")));
//         cq.orderBy(cb.asc(student.get("id")));

        CriteriaQuery<StudentEntity> cq_select = cq.select(student);

        TypedQuery<StudentEntity> q = em.createQuery(cq_select);

        @SuppressWarnings("unchecked")
        List<StudentEntity> list = q.getResultList();

        System.out.println("    Student Record");
        System.out.println("#######################");
        System.out.println("Id       Name       Age");
        System.out.println("########################");
        for (StudentEntity name : list) {
            System.out.println(name.getId() + "  " + name.getName() + "   " + name.getAge());
            System.out.println("-------------------------");
        }

        em.close();
        emf.close();
    }
}
