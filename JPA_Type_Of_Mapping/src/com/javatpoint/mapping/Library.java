
package com.javatpoint.mapping;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Library implements Serializable {
    
    @Id
    private int id;///
    private String book;
    
   @OneToOne // we get all record
  //  @OneToOne(mappedBy = "library") /// we can not get Student class record
    private Student std ;
   
   @ManyToMany(targetEntity = Student.class)
   private List<Student> mstu;

    public List<Student> getMstu() {
        return mstu;
    }

    public void setMstu(List<Student> mstu) {
        this.mstu = mstu;
    }



    public Library(int id, String book, Student std) {
        super();
        this.id = id;
        this.book = book;
        this.std = std;
    }

    public Library() {
        super();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }
    
    
}
