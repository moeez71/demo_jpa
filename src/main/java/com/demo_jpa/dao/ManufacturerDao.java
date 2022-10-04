package com.demo_jpa.dao;

import com.demo_jpa.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDao extends JpaRepository<Manufacturer,Integer> {
}
