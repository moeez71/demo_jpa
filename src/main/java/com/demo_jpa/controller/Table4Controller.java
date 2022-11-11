package com.demo_jpa.controller;

import com.demo_jpa.entity.Table4;
import com.demo_jpa.entity.TableInput;
import com.demo_jpa.response.ResponseHandler;
import com.demo_jpa.service.Table4Service;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class Table4Controller{
    public static Logger log = LoggerFactory.getLogger(Table4Controller.class);

    @Autowired
    private Table4Service table4Service;



    @QueryMapping("allTable4s")
    public Object getProducts() {
        List<Table4> products = table4Service.getProd();
        log.info("products viewed");
       // return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
       // return ResponseEntity.status(HttpStatus.OK).body(products);
        return products;
    }

    @QueryMapping("getTable4")
    public Object getTable4Record(@Argument Integer entryId) {
        Optional<Table4> products = table4Service.getTable4Record(entryId);
        if (products.isPresent()){
             return products;
    }//return products;
    return null;
    }


    @PostMapping("savetable4")
    public ResponseEntity<Object> saveTable4Record(@RequestBody Table4 p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   table4Service.addTable4Record(p));
    }

    @MutationMapping("createTable4")
    public Object saveTable4Record2(@Argument TableInput entry) {

        Table4 tab = new Table4();
        tab.setBool(entry.getBool());
        tab.setName(entry.getName());
        return table4Service.addTable4Record(tab);
    }

    @PostMapping("updatetable4/{idtable4}")
    public ResponseEntity<Object> updateTable4Record(@PathVariable Integer idtable4,@RequestBody Table4 p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   table4Service.updateTable4Record(idtable4, p));
    }

    @MutationMapping("deleteEntry")
    public void deleteProd(@Argument int id) {
          table4Service.deleteEntry(id);
        //return ResponseHandler.generateResponse("Success", HttpStatus.OK,   new EmptyJsonBody());
    }

    @MutationMapping("updateTable")
    public Object updateProd2( @Argument Table4 entry) {
       // return ResponseHandler.generateResponse("Success", HttpStatus.OK,   productService.updateProduct2( name,  p2));
        Table4 tab = new Table4();
        tab.setId(entry.getId());
        tab.setBool(entry.getBool());
        tab.setName(entry.getName());
        return table4Service.updateTable4(tab);
    }




    @Data
class BookInput{
        private Boolean bool;
        private String name;
}




}
