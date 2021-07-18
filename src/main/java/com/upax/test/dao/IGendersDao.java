/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.dao;

import com.upax.test.entity.Genders;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Biye-Ishel
 */
public interface IGendersDao extends CrudRepository<Genders, Long> {
    
}
