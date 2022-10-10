package com.demo_jpa.service;

import com.demo_jpa.dao.ProductDao;
import com.demo_jpa.entity.Product;
import com.demo_jpa.entity.Product2;
import com.demo_jpa.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public List<Product> getProd(){
        return productDao.findAll();
    }

    public Product getProdByName(String name){
        return productDao.findByProductName(name);
    }

    public Product addProduct( Product p){
        return productDao.save(p);
    }

    public void deleteProduct(int id){
        productDao.deleteById(id);
    }

    public Product updateProduct(int id, Product p2){
        Product p = productDao.findById(id).get();
        p.setProductName(p2.getProductName());
        //p.setManufacturer(p2.getManufacturer());
        return productDao.save(p);

    }


    public List<Product> getProdsByManuName(String manuName){
        return productDao.findProductByManufacturer_ManufacturerName(manuName);
    }

    public ResponseEntity<Object> doesProductExist(String name){
        Product p = productDao.doesProductExist(name);

        return ResponseHandler.generateResponse("Success", HttpStatus.OK, p);
        // return ResponseHandler.generateResponse("Does not Exist", HttpStatus.MULTI_STATUS, null);
    }
    public List<Product2> getProdsNameAndId(){
        return productDao.getPNameAndId();
    }

    public List<ProductDao.Test> getProdsNameAndIdNativeQuery(){
        return productDao.getPNameAndIdNativeQuery();
    }

    public List<ProductDao.Test> getProdsByManu(String id){
        return productDao.getProdsByManufatureId(id);
    }


}
