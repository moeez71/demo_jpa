package com.demo_jpa.controller;

import com.demo_jpa.dao.ProductDao;
import com.demo_jpa.entity.Product;
import com.demo_jpa.entity.Product2;
import com.demo_jpa.exceptionhandling.AnyCustomException;
import com.demo_jpa.response.EmptyJsonBody;
import com.demo_jpa.response.ResponseHandler;
import com.demo_jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    public static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("getprod")
    public ResponseEntity<Object> getProducts() {
        List<Product> products = productService.getProd();
        log.info("products viewed");
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }


    @GetMapping("getprodbyname/{name}")
    public Object getProductByName(@PathVariable String name) {
        Product products = productService.getProdByName(name);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
        //return products;
    }

    @GetMapping("getprodbymanufacturername/{name}")
    public ResponseEntity<Object> getProdByManuName(@PathVariable String name) {
        List<Product> products = productService.getProdsByManuName(name);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }

    @GetMapping("getprodbymanufacturerid/{id}")
    public ResponseEntity<Object> getProdByManuId(@PathVariable String id) {
        List<ProductDao.Test> products = productService.getProdsByManu(id);
        if(products.isEmpty()){
            throw new AnyCustomException("Does not exist");
        }
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }

    @GetMapping("getprodnameandid")
    public ResponseEntity<Object> getProdNameAndId() {
        List<Product2> products = productService.getProdsNameAndId();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }

    @GetMapping("getprodnameandidnative")
    public ResponseEntity<Object> getProdNameAndIdNativeQuery() {
        List<ProductDao.Test> products = productService.getProdsNameAndIdNativeQuery();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }

    @PostMapping("saveprod")
    public ResponseEntity<Object> saveProd(@RequestBody Product p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   productService.addProduct(p));
    }

    @GetMapping("doesprodexist/{name}")
    public ResponseEntity<Object> doesProdExist(@PathVariable(required = true) String name ) {

        return productService.doesProductExist(name);
    }

    @PostMapping("updateprod/{id}")
    public ResponseEntity<Object> updateProd(@PathVariable int id, @RequestBody Product p2) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   productService.updateProduct( id,  p2));
    }

    @PostMapping("updateprod2/{name}")
    public ResponseEntity<Object> updateProd2(@PathVariable String name, @RequestBody Product p2) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   productService.updateProduct2( name,  p2));
    }

    @DeleteMapping("deleteprod/{id}")
    public ResponseEntity<Object> deleteProd(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   new EmptyJsonBody());
    }




}
