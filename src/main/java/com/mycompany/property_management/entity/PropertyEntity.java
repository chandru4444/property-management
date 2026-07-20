package com.mycompany.property_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="PROPERTY_TABLE")

@Getter
@Setter
@NoArgsConstructor

public class PropertyEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "PROPERTY_TITLE",nullable = false)

    private String title;
    private String description;
    private String ownerName;
    @Column(name = "MAIL",nullable = true)
    private String ownerEmail;
    private String address;
    private  Double price;



}
