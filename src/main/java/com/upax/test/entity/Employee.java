/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Biye-Ishel
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    @Column(name="last_name")
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    
    @Column(name="gender_id")
    private Long gedner_id;
    
     @Column(name="job_id")
    private Long job_id; 

    public Long getGedner_id() {
        return gedner_id;
    }

    public void setGedner_id(Long gedner_id) {
        this.gedner_id = gedner_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

   
    
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="gender_id", referencedColumnName = "id")
//    private Genders genders=new Genders();
//    
//    @OneToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="job_id", referencedColumnName = "id")
//    private Jobs jobs=new Jobs();
//    
    
    
    
    private static final long serialVersionUID=1L;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

   

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdate + ", gedner_id=" + gedner_id + ", job_id=" + job_id + '}';
    }

    

    


   

    

    
}
