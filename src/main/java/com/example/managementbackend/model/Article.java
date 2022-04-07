package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article")
    private List<ArticleUtilisee> bcassociation = new ArrayList<ArticleUtilisee>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Article(String code, String designation, String unitee, Metier metier, List<ArticleUtilisee> bcassociation, Type type) {
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.metier = metier;
        this.bcassociation = bcassociation;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public List<ArticleUtilisee> getBcassociation() {
        return bcassociation;
    }

    public void setBcassociation(List<ArticleUtilisee> bcassociation) {
        this.bcassociation = bcassociation;
    }

}
