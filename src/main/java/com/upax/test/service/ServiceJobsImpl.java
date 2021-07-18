/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;

import com.upax.test.dao.IJobsDao;
import com.upax.test.entity.Jobs;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

/**
 *
 * @author Biye-Ishel
 */
@Service
public class ServiceJobsImpl implements IServiceJobs {
    @Autowired
    IJobsDao jobsDao;

    @Override
    public List<Jobs> findAll() {
        return  (List<Jobs>) jobsDao.findAll();
    }

    @Override
    public Jobs findById(Long id) {
        return jobsDao.findById(id).orElse(null);
    }

    

    @Override
    public void addJob(Jobs job) {
        jobsDao.save(job);
    }
    
}
