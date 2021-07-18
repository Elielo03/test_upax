/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.service;

import com.upax.test.entity.Genders;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Biye-Ishel
 */
public interface IServiceGenders  {
    
     public List<Genders> findAll();
     public void saveGender(Genders genders);
     public Optional<Genders> findById(Long id);
}
