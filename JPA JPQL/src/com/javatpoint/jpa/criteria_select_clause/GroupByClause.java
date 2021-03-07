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
import javax.persistence.criteria.Root;

public class GroupByClause {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_Details");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<StudentEntity> stud = cq.from(StudentEntity.class);

        cq.multiselect(stud.get("name"), cb.count(stud))
                .groupBy(stud.get("name"))
                .having(cb.notLike(stud.get("name"), "%R%"));

        System.out.print("age");
        System.out.println("\t \tCount");

        List<Object[]> list = em.createQuery(cq).getResultList();

        for (Object[] object : list) {

            System.out.println(object[0] + "     " + object[1]);

        }

        em.close();
        emf.close();
    }
}
