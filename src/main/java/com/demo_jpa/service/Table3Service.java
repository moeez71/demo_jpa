package com.demo_jpa.service;

import com.demo_jpa.entity.Table3;
import com.demo_jpa.dao.Table3Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Table3Service {

    @Autowired
    private Table3Dao table3DaoDao;

   /// @CachePut always lets the method execute. It is generally used if you want your cache to be updated with the result of the method execution.
   /// Example: When you want to update a stale data which is cached, instead of blowing the cache completely.

   /// @Cacheable will be executed only once for the given cachekey and subsequent requests won't execute the method, until the cache expires or gets flushed.


    //caches record if result is not null
    @Cacheable(value = "table3", key = "#id", unless="#result == null")
    public Optional<Table3> getTable3Record(Integer id){
        System.out.println("Got Data By Db");
        return table3DaoDao.findById(id);
    }

    //only caches records if id < 2
    @Cacheable(value = "table3", key = "#p.id", unless = "#result.id > 2")
    public Table3 addTable3Record(Table3 p){
        return table3DaoDao.save(p);
    }

    //used for updating record in cache and in db also against #id
    @CachePut(value = "table3", key = "#id")
    public Table3 updateTable3Record(Integer id, Table3 p2){
        Table3 p = table3DaoDao.findById(id).get();
        p.setName(p2.getName());
        p.setBool(p2.getBool());
        return table3DaoDao.save(p);

    }





}
