package com.example.managementbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "organisation")

public class Organisation {

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


      /*  @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "organisation")
        private List<Entreprise> entreprises = new ArrayList<>();*/

        @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "org")
        private List<Marchee> marchees = new ArrayList<>();


        // Getters and Setters (Omitted for brevity)




}

