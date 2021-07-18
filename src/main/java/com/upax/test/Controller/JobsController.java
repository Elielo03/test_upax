/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.Controller;

import com.upax.test.entity.Jobs;
import com.upax.test.service.IServiceJobs;
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
    
    @PostMapping("/addJob")
    public ResponseEntity<?>addJob(@RequestBody Jobs job){
        serviceJobs.addJob(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/getJobById")
    public ResponseEntity<?>getJob(@RequestBody Jobs job){
        
        job= serviceJobs.findById(job.getId());
        return new ResponseEntity<>(job,HttpStatus.OK);
    }
    
}
