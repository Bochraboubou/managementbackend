package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

public class Marchee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String secteur_d_activitee;

    @NotNull
    private String metier;


    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String budget;

    @NotNull
    private String type;

    @NotNull
    private float montant;

    @NotNull
    private String delais;

    @NotNull
    private String gouvernerat;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation org;

    // Getters and Setters (Omitted for brevity)


}
