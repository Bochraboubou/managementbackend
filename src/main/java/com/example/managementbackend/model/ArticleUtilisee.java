package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "articleutilisee")
public class ArticleUtilisee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String designation;


    @NotNull
    private String unitee;


    @NotNull
    private float prix;


    @NotNull
    private long quantitee;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bc_id", nullable = false)
    private BondeCommande bondecommande;

    public ArticleUtilisee(String code, String designation, String unitee, float prix, long quantitee, BondeCommande bondecommande) {
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.prix = prix;
        this.quantitee = quantitee;
        this.bondecommande = bondecommande;
    }

    public ArticleUtilisee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUnitee() {
        return unitee;
    }

    public void setUnitee(String unitee) {
        this.unitee = unitee;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }

    public BondeCommande getBondecommande() {
        return bondecommande;
    }

    public void setBondecommande(BondeCommande bondecommande) {
        this.bondecommande = bondecommande;
    }
}
