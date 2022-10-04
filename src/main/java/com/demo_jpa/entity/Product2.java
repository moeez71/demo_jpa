package com.demo_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

//Used for JPQl Query Example
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product2 {

    private Integer productId;
    private String productName;



}