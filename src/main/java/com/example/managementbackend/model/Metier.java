package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "metier")
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomMetier;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secteur_id", nullable = false)
    private Secteur secteur;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "metier")
    private List<Article> articles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "metier")
    private List<Marchee> marchees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "metier")
    private List<Type> types = new ArrayList<>();



    public Metier() {

    }

    public Metier(String nomMetier, Secteur secteur, List<Article> articles, List<Marchee> marchees, List<Type> types) {
        this.nomMetier = nomMetier;
        this.secteur = secteur;
        this.articles = articles;
        this.marchees = marchees;
        this.types = types;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMetier() {
        return nomMetier;
    }

    public void setNomMetier(String nomMetier) {
        this.nomMetier = nomMetier;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Metier(String nomMetier, Secteur secteur) {
        this.nomMetier = nomMetier;
        this.secteur = secteur;

    }

}
