package com.demo_jpa.service;

import com.demo_jpa.dao.Table4Dao;
import com.demo_jpa.entity.Table4;
import com.demo_jpa.exceptionhandling.AnyCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Table4Service {

    @Autowired
    private Table4Dao table4DaoDao;


    public List<Table4> getProd(){
        System.out.println("Got Data By Db");
        return table4DaoDao.findAll();
    }

    public void deleteEntry(int id){
        if(table4DaoDao.existsById(id)){
         table4DaoDao.deleteById(id);}
       else{
           System.out.println("Does not exist");
        }

    }

    public Table4 updateTable4(Table4 clientTableBean){
        Optional<Table4> personDbBean = table4DaoDao.findById(clientTableBean.getId());

        if(!personDbBean.isPresent()){
            return null;
        }
        Table4 table4Bean = personDbBean.get();

        table4Bean.setName(clientTableBean.getName());
        table4Bean.setBool(clientTableBean.getBool());

        return table4DaoDao.save(table4Bean);


    }

    public Optional<Table4> getTable4Record(Integer id){
        System.out.println("Got Data By Db");
        return table4DaoDao.findById(id);
    }

    public Table4 addTable4Record(Table4 p){
        return table4DaoDao.save(p);
    }


    public Table4 updateTable4Record(Integer id, Table4 p2){
        Table4 p = table4DaoDao.findById(id).get();
        p.setName(p2.getName());
        p.setBool(p2.getBool());
        return table4DaoDao.save(p);

    }





}
