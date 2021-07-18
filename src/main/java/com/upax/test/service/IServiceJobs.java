/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;


import com.upax.test.entity.Jobs;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

/**
 *
 * @author Biye-Ishel
 */
public interface IServiceJobs {
     public List<Jobs> findAll();
     public Jobs findById(Long id);
     public void addJob(Jobs job);
    
}
