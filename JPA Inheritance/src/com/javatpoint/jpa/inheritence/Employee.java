package com.javatpoint.jpa.inheritence;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//InheritanceType.SINGLE_TABLE:
// 1. single table only generated.
//InheritanceType.JOINED:
// 2. In joined strategy, a separate table is generated for every entity class. The attribute of each table is joined with the primary key.
//InheritanceType.TABLE_PER_CLASS:
// 3. In table-per-class strategy, for each sub entity class a separate table is generated.

@Entity
@Table(name = "Employee")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
//@Inheritance(strategy=InheritanceType.JOINED)  
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
public class Employee implements Serializable {
    
    @Id
    private  int id;
    private  String name;

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Employee() {
        super();
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
