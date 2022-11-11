package com.demo_jpa.dao;

import com.demo_jpa.entity.Manufacturer;
import com.demo_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);
}
