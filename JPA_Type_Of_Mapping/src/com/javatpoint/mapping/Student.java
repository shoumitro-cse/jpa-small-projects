package com.javatpoint.mapping;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student implements Serializable {

    @OneToOne(mappedBy = "std")
    private Library library;

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private  String name;
    
   @OneToMany(targetEntity=Library.class) 
    private List<Library> book_list;
   
   @ManyToOne(targetEntity=Library.class)
   private Library lib;
   
   @ManyToMany(targetEntity = Library.class)
   private List<Library> mlib;

    public List<Library> getMlib() {
        return mlib;
    }

    public void setMlib(List<Library> mlib) {
        this.mlib = mlib;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }

    public List<Library> getBook_list() {
        return book_list;
    }

    public void setBook_list(List<Library> book_list) {
        this.book_list = book_list;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
