/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;

import com.upax.test.dao.IEmployeesDao;
import com.upax.test.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Biye-Ishel
 */
@Service
public class ServiceEmployeesImpl implements ISserviceEmployees {
    @Autowired IEmployeesDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
        
    }

    

    @Override
    public Employee findByNameAndLastName(Employee employee) {
        return employeeDao.findByNameAndLastName(employee.getName(),employee.getLastName());
    }

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeDao.findAll();
    }
    
}
