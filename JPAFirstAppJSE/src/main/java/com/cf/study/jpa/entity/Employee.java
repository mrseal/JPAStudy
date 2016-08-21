package com.cf.study.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private long salary;

    public Employee() {

    }

    public Employee(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(final long salary) {
        this.salary = salary;
    }

}
