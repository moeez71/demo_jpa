package com.demo_jpa.service;

import com.demo_jpa.dao.ManufacturerDao;
import com.demo_jpa.entity.Manufacturer;
import com.demo_jpa.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureService {

    @Autowired
    ManufacturerDao manufacturerDao;

    public List<Manufacturer> getManu(){
        return manufacturerDao.findAll();
    }

    public Manufacturer addManu( Manufacturer p){
        return manufacturerDao.save(p);
    }
}
