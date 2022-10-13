package com.demo_jpa.service;

import com.demo_jpa.entity.Table3;
import com.demo_jpa.dao.Table3Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class Table3Service {

    @Autowired
    private Table3Dao table3DaoDao;


    @Cacheable(value = "table3", key = "#id")
    public Table3 getTable3Record(Integer id){
        System.out.println("got data by db");
        return table3DaoDao.findById(id).get();
    }

    @Cacheable(value = "table3", key = "#p.id")
    public Table3 addTable3Record(Table3 p){
        return table3DaoDao.save(p);
    }

    @CachePut(value = "table3", key = "#id")
    public Table3 updateTable3Record(Integer id, Table3 p2){
        Table3 p = table3DaoDao.findById(id).get();
        p.setName(p2.getName());
        p.setBool(p2.getBool());
        return table3DaoDao.save(p);

    }





}
