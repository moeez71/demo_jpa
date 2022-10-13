package com.demo_jpa.dao;

import com.demo_jpa.entity.Product;
import com.demo_jpa.entity.Product2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    Product findByProductName(String name);

    List<Product> findProductByManufacturer_ManufacturerName(String name);

    //Jpql example
    @Query("select p from Product p where p.productName = ?1")
    Product doesProductExist(String name);

    //Jpql example
    @Query("select  new com.demo_jpa.entity.Product2( p.productId,p.productName) from Product p")
    List<Product2> getPNameAndId();

    @Query(value = "SELECT product_name as firstname, product_id as id from product;",
    nativeQuery = true)
    List<Test> getPNameAndIdNativeQuery();

    @Query(value = "SELECT product_name as firstname, product_id as id from product where manufacturer_id= :manufacturer_id ;",
            nativeQuery = true)
    List<Test> getProdsByManufatureId(@Param("manufacturer_id") String id);




    //For_Native_Query_Testing
    public static interface Test {

        String getFirstname();

        int getId();
    }

}
