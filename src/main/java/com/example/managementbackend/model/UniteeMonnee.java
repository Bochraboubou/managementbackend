package com.example.managementbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
@Entity
@Table(name = "unitee")
public class UniteeMonnee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String libelUnitee;






}

