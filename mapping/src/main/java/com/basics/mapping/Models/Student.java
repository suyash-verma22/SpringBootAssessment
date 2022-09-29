package com.basics.mapping.Models;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String department;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void printStudentInfo(){
        System.out.println("Student Information:- ");
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Department: " + this.department);
    }
}
