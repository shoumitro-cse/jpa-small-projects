import javax.persistence.*;  
public class PersistStudent {  
      
    public static void main(String args[]) {  
		    
  
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
	   EntityManager em=emf.createEntityManager();  
	     
	   em.getTransaction().begin();  
	     
	   StudentEntity s1=new StudentEntity();  
	   s1.setS_id(102);  
	   s1.setS_name("Shoumitro");  
	   s1.setL_name("Roy");  
	   s1.setS_age(22);  
	     
	   em.persist(s1);         
	
	   em.getTransaction().commit();  
	     
	 
	   em.close(); 
	   emf.close();  
 
           EntityManagerFactory emf1=Persistence.createEntityManagerFactory("Student_details");  
	   EntityManager em1=emf1.createEntityManager(); 
	    
          StudentEntity s=em1.find(StudentEntity.class, 102);  

          System.out.println("Student id = "+s.getS_id());  
          System.out.println("Student Name = "+s.getS_name());  
          System.out.println("Student last = "+s.getL_name());  
          System.out.println("Student Age = "+s.getS_age());  
    }  
}  
//  <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/any_db_no_exist_mdb"/>  