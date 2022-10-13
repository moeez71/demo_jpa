package com.demo_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "table3")
@Data
public class Table3 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtable3", nullable = false)
    private Integer id;

    @Column(name = "bool")
    private Boolean bool;

    @Column(name = "name", length = 45)
    private String name;



}