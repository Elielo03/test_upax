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
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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
public class JobsController {
    @Autowired
    IServiceJobs serviceJobs;
    
    @Autowired
    ISserviceEmployees serviceEmployee;
    
    @PostMapping("/addJob")
    public ResponseEntity<?>addJob(@RequestBody Jobs job){
        serviceJobs.addJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/getJobById")
    public ResponseEntity<?>getJob(@RequestBody Jobs job){
        
        job= serviceJobs.findById(job.getId());
        List<Employee> list=serviceEmployee.getAll();
        System.out.println("tam: "+list.size());
        
        Long idJob=job.getId();

         List<Employee> listFiltered = list
        .stream()
        .filter(c -> Objects.equals(c.getJob_id(), idJob))
        .collect(Collectors.toList());
         System.out.println("tam customer: "+listFiltered.size());
         listFiltered.sort(Comparator.comparing(a -> a.getLastName()));
        return new ResponseEntity<>(listFiltered,HttpStatus.OK);
    }
    
}
