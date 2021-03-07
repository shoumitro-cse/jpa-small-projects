package build_jpa;

import build_jpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find {

    public static void main(String[] args) throws NonexistentEntityException, Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        StudentJpaController sc = new StudentJpaController(emf);

        // Student ed = em.find(Student.class, 101);
        Student s1 = sc.findStudent(101); //find student

        System.out.println(".........First Record..............");
        System.out.println("Id  : " + s1.getId());
        System.out.print("Name : " + s1.getFirstName() + " " + s1.getLastName());
        System.out.println("\nAge  : " + s1.getAge());

        System.out.println("\n\nTotal Student Number : " + sc.getStudentCount());

        List<Student> list = sc.findStudentEntities();
        System.out.println("\n\n...........Total Student Record............\n");
        for (Student s : list) {
            System.out.println("Id  : " + s.getId());
            System.out.print("Name : " + s.getFirstName() + " " + s.getLastName());
            System.out.println("\nAge  : " + s.getAge());
            System.out.println("......................");
        }

//        Student editS = new  Student();
//        editS.setId(101);
//        editS.setFirstName("Raju");
//        editS.setLastName("Hossain");
//        editS.setAge(22);
        //    sc.edit(editS);// marge student or edit student
        Student student = new Student();
        student.setId(104);
        student.setFirstName("Farjana");
        student.setLastName("Begum");
        student.setAge(23);

        // sc.create(student);// insert new record 
        // em.persist(student);
        //   sc.destroy(104);  // remove record from table
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
