/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.Controller;

import com.upax.test.entity.Employee;
import com.upax.test.entity.Jobs;
import com.upax.test.service.IServiceJobs;
import com.upax.test.service.ISserviceEmployees;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Biye-Ishel
 */
@RequestMapping("/api")
@RestController
public class EmployeesController {
    @Autowired
    ISserviceEmployees serviceEmployee;
    
    @Autowired
    IServiceJobs serviceJobs;
    
    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employoee){
       Employee employeDb= serviceEmployee.findByNameAndLastName(employoee);
       Jobs job= serviceJobs.findById(employoee.getJob_id());
        
       if (employeDb!=null){
           return new ResponseEntity<>(HttpStatus.CONFLICT);
       }else{
           //Validacion de fecha
           Date input = employoee.getBirthdate();
           System.out.println("La fecha es: "+input);
           LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           Period age = Period.between(date, LocalDate.now());
           
           if(age.getYears()<18){
               return new ResponseEntity<>(HttpStatus.CONFLICT);
           } else{
               //validacion de Job
               if(job!=null ){
                   serviceEmployee.addEmployee(employoee);
                    return new ResponseEntity<>(HttpStatus.CREATED);
               }else{
                   return new ResponseEntity<>(HttpStatus.CONFLICT);
               }
               
               
           }
           
       }
    }
    
    @GetMapping("/getAllEmployees")
    public ResponseEntity<?>getAll(){
        
         List<Employee> list=serviceEmployee.getAll();
        if (list!= null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
