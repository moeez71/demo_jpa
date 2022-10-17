package com.demo_jpa.controller;

import com.demo_jpa.entity.Table3;
import com.demo_jpa.response.ResponseHandler;
import com.demo_jpa.service.Table3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Table3Controller {
    public static Logger log = LoggerFactory.getLogger(Table3Controller.class);

    @Autowired
    private Table3Service table3Service;



    @GetMapping("gettable3byid/{id}")
    public Object getTable3Record(@PathVariable Integer id) {
        Optional<Table3> products = table3Service.getTable3Record(id);
        if (products.isPresent()){
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }//return products;
    return null;
    }


    @PostMapping("savetable3")
    public ResponseEntity<Object> saveTable3Record(@RequestBody Table3 p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   table3Service.addTable3Record(p));
    }

    @PostMapping("updatetable3/{idtable3}")
    public ResponseEntity<Object> updateTable3Record(@PathVariable Integer idtable3,@RequestBody Table3 p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   table3Service.updateTable3Record(idtable3, p));
    }

    // used to clear all cache values against table3
    @GetMapping("deletecachetable3")
    @CacheEvict(value = "table3", allEntries=true)
    public Boolean delCacheTable3() {
        return true;

    }




}
