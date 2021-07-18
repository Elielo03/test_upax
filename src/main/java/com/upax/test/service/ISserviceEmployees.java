/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;

import com.upax.test.entity.Employee;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Biye-Ishel
 */
public interface ISserviceEmployees {
    public void addEmployee(Employee employee);
    public Employee findByNameAndLastName(Employee employee);
    public List<Employee> getAll();
}
