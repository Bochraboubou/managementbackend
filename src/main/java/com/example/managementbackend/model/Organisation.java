package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
//@Table(name ="Organisation")
@Data
public class Organisation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(unique = true)
        private String nom;


        @NotNull
        @Column(unique = true)
        private String code;


        @NotNull
        private String secteur_d_activite;

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
        @com.sun.istack.NotNull
        private String nomAdmin;


        @com.sun.istack.NotNull
        private long telAdmin;


        @com.sun.istack.NotNull
        private String emailAdmin;

        private String  document;
        private String filename;


        @JsonIgnore
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "organisation")

        private List<User> users;

        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "org")
        private List<Marchee> marchees = new ArrayList<>();




}

