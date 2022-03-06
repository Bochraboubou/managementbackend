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
    private String secteurd_activitee;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metier_id", nullable = false)
    private Metier metier;


    // Getters and Setters


    public Marchee(String secteurd_activitee, String code, String designiation, String budget, String type, float montant, long delais, Organisation org, List<BondeCommande> bondes, Metier metier) {
        this.secteurd_activitee = secteurd_activitee;
        this.code = code;
        this.designiation = designiation;
        this.budget = budget;
        this.type = type;
        this.montant = montant;
        this.delais = delais;
        this.org = org;
        this.bondes = bondes;
        this.metier = metier;
    }

    public Marchee() {

    }

    public String getDesigniation() {
        return designiation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecteurd_activitee() {
        return secteurd_activitee;
    }

    public void setSecteurd_activitee(String secteurd_activitee) {
        this.secteurd_activitee = secteurd_activitee;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesigniation(String designiation) {
        this.designiation = designiation;
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

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }
}
