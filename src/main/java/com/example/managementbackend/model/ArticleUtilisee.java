package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "articleutilisee")
public class ArticleUtilisee {

    @EmbeddedId
    private  AticleUtiliseeId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("bondecommande_id") //This is the name of attr in Article utiliseePK class
    @JoinColumn(name = "bondecommande_id")
    private BondeCommande bondecommande;

    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private float prix;


    @NotNull
    private float quantitee;



    public ArticleUtilisee(BondeCommande bondecommande, Article article, float prix, float quantitee) {
        // create primary key
        this.id = new AticleUtiliseeId(bondecommande.getId(), article.getId());


        // initialize attributes
        this.bondecommande = bondecommande;
        this.article = article;
        this.prix = prix;
        this.quantitee = quantitee;
    }

    public ArticleUtilisee() {

    }




}
