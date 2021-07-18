/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;

import com.upax.test.entity.Genders;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.upax.test.dao.IGendersDao;
import org.springframework.stereotype.Service;

/**
 *
 * @author Biye-Ishel
 */
@Service
public class ServiceGenderImpl implements IServiceGenders{
    @Autowired
    private IGendersDao daoGenders;

    @Override
    public List<Genders> findAll() {
        return (List<Genders>) daoGenders.findAll();
    }

    @Override
    public void saveGender(Genders genders) {
        daoGenders.save(genders);
    }

    @Override
    public Optional<Genders> findById(Long id) {
        return daoGenders.findById(id);
    }
    
}
