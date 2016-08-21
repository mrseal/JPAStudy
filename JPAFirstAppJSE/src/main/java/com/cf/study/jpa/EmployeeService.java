package com.cf.study.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cf.study.jpa.entity.Employee;

public class EmployeeService {

    private final EntityManager em;

    public EmployeeService(final EntityManager em) {
        this.em = em;
    }

    public Employee createEmployee(final int id, final String name, final long salary) {
        final Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    public Employee findEmployee(final int id) {
        return em.find(Employee.class, id);
    }

    public void removeEmployee(final int id) {
        final Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Employee raiseSalary(final int id, final long raise) {
        final Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() + raise);
        }
        return emp;
    }

    public List<Employee> findAllEmployees() {
        final TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    // public int setName(final int id, final String name) {
    // final Query query =
    // em.createQuery("UPDATE Employee e SET e.name=:name WHERE e.id=:id");
    // return query.setParameter("name", name).setParameter("id",
    // id).executeUpdate();
    // }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void test() {
        System.out.println("Employee service is running: EntityManager=" + em);
    }

}
