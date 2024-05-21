package com.maids.cc.Library.Management.System.model.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table( name = "Patron")
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specify the generation strategy
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "EMAIL")
    private String email;
}
