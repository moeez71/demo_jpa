package com.demo_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "table4")
@Data
public class Table4 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtable4", nullable = false)
    private Integer id;

    @Column(name = "bool")
    private Boolean bool;

    @Column(name = "name", length = 45)
    private String name;



}