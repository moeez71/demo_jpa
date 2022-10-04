package com.demo_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manufacturer")
@Setter
@Getter
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer manufacturerId;

    @Column(name = "name", nullable = false, length = 45)
    private String manufacturerName;

    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference
    private List<Product> product;

}