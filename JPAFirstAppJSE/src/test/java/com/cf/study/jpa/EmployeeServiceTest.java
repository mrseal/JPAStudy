package com.cf.study.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.cf.study.jpa.entity.Employee;

public class EmployeeServiceTest {

    @Test
    public void test() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        final EntityManager em = emf.createEntityManager();
        final EmployeeService service = new EmployeeService(em);
        service.test();

        service.begin();
        service.createEmployee(1, "James", 289310);
        service.commit();
        assertEquals(1, service.findAllEmployees().size());

        final Employee emp = service.findEmployee(1);
        assertNotNull(emp);
        assertEquals(289310, emp.getSalary());

        service.begin();
        service.raiseSalary(1, 3000);
        service.commit();
        assertEquals(292310, service.findEmployee(1).getSalary());

        service.begin();
        service.removeEmployee(1);
        service.commit();
        assertNull(service.findEmployee(1));
        assertEquals(0, service.findAllEmployees().size());

        em.close();
        emf.close();
    }
}
