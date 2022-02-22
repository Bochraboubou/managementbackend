package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "bondecommande")
public class BondeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private float montant;

    @NotNull
    private String delais;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    @NotNull
    private Entreprise entreprise;

    @NotNull
    private String adresse;

    @NotNull
    private long tel;

    @NotNull
    private String gouvernerat;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)
    private Marchee marchee;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    // Getters and Setters (Omitted for brevity)

}
