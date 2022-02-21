package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marchee")
public class Marchee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String secteurD_activitee;

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
    private long delais;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation org;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "marchee")
    private List<BondeCommande> bondes = new ArrayList<>();


    // Getters and Setters (Omitted for brevity)


}
