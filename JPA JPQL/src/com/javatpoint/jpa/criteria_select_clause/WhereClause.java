package com.javatpoint.jpa.criteria_select_clause;

import com.javatpoint.jpa.StudentEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class WhereClause {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        AbstractQuery<StudentEntity> aq = cb.createQuery(StudentEntity.class);

        Root<StudentEntity> student = aq.from(StudentEntity.class);

        // aq.where(cb.greaterThan((Path)student.get("age"), 23));
        //  aq.where(cb.lessThan((Path)student.get("age"), 23));
        // aq.where(cb.greaterThanOrEqualTo((Path)student.get("age"), 23));
        //   aq.where(cb.ge((Path)student.get("age"), 23));
        //  aq.where(cb.lessThanOrEqualTo((Path)student.get("age"), 23));
        //  aq.where(cb.between((Path)student.get("age"), 23,24));
        //  aq.where(cb.like((Path)student.get("name"),"%ro%"));
        //  aq.where(cb.in(student.get("age")).value(22).value(23));
        // aq.where(cb.isNull(student.get("age")));
        // aq.where(cb.isNotNull(student.get("age")));
        // aq.where(cb.not(student.get("age")));
        aq.where(cb.notLike(student.get("name"), "%R%"));

        CriteriaQuery<StudentEntity> select = ((CriteriaQuery<StudentEntity>) aq).select(student);

        TypedQuery<StudentEntity> q = em.createQuery(select);

        @SuppressWarnings("unchecked")
        List<StudentEntity> list = q.getResultList();

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
