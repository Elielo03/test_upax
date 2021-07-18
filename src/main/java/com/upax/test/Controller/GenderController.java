/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upax.test.Controller;

import com.upax.test.entity.Genders;
import com.upax.test.service.IServiceGenders;
import java.util.List;
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
public class GenderController {
    @Autowired
    private IServiceGenders serviceGender;
    
    @PostMapping("/saveGender")
    public ResponseEntity<?> saveGender(@RequestBody Genders gender){
        
        serviceGender.saveGender(gender);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/genders")
    public ResponseEntity<?> listaCursos(){
        List<Genders> listaGenders=serviceGender.findAll();
        if (listaGenders!= null){
            return new ResponseEntity<>(listaGenders,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
     
}
