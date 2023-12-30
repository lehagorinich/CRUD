package com.alexpozdnyakov.spring.rest.dao;

import com.alexpozdnyakov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository

public class EmloyeeDAOimpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();
        List<Employee> AllEmployees=session.createQuery("from Employee",Employee.class)
                .getResultList();
        return AllEmployees;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Employee employee=session.get(Employee.class,id);
        return employee;

    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Employee> query=session.createQuery("delete from Employee where id=:employeeID");
        query.setParameter("employeeID",id);
    }
}
