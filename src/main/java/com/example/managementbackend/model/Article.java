package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
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



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metier_id", nullable = false)
    private Metier metier;

    public Article(String code, String designation, String unitee, Metier metier) {
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.metier = metier;
    }

    public Article() {

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

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }
}
