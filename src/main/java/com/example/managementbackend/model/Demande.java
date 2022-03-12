package com.example.managementbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demande {
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
}
