package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "entreprise")
public class Entreprise {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(unique = true)
        private String nom;

        @NotNull
        private String secteur_d_activité;

        @NotNull
        private String email;

        @NotNull
        private String pays;

        @NotNull
        private String region;

        @NotNull
        private String adresse;

        @NotNull
        private long tel;

        @NotNull
        private String type;


        @NotNull
        private String nomDG;


        @NotNull
        private long telDG;


        @NotNull
        private String emailDG;


        @NotNull
        private String nomAdmin;


        @NotNull
        private long telAdmin;


        @NotNull
        private String emailAdmin;
       @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "organisation_id", nullable = false)
        private Organisation organisation;

        // Getters and Setters (Omitted for brevity)



}
