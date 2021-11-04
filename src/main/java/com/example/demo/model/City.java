package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class City {

    @Id
    private Long id;
    private String name;
    private String state;
    private String country;

}
