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
    private String designiation;


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


    // Getters and Setters


    public Marchee(String secteurD_activitee, String metier, String code, String designiation, String budget, String type, float montant, long delais, Organisation org, List<BondeCommande> bondes) {
        this.secteurD_activitee = secteurD_activitee;
        this.metier = metier;
        this.code = code;
        this.designiation = designiation;
        this.budget = budget;
        this.type = type;
        this.montant = montant;
        this.delais = delais;
        this.org = org;
        this.bondes = bondes;
    }

    public Marchee() {

    }

    public String getDesigniation() {
        return designiation;
    }

    public void setDesigniation(String designiation) {
        this.designiation = designiation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecteurD_activitee() {
        return secteurD_activitee;
    }

    public void setSecteurD_activitee(String secteurD_activitee) {
        this.secteurD_activitee = secteurD_activitee;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public long getDelais() {
        return delais;
    }

    public void setDelais(long delais) {
        this.delais = delais;
    }

    public Organisation getOrg() {
        return org;
    }

    public void setOrg(Organisation org) {
        this.org = org;
    }

    public List<BondeCommande> getBondes() {
        return bondes;
    }

    public void setBondes(List<BondeCommande> bondes) {
        this.bondes = bondes;
    }
}
