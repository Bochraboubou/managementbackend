package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "articlerealisee")
public class ArticleRealisee {
    @EmbeddedId
    private  ArticleRealiseeId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("attachement_id") //This is the name of attr in Article realiseePK class
    @JoinColumn(name = "attachement_id")
    private Attachement attachement;

    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private long quantiteeRealisee;

    public ArticleRealisee(Attachement attachement, Article article, long quantiteeRealisee) {
        // create primary key
        this.id = new ArticleRealiseeId(attachement.getId(), article.getId());

        // initialize attributes
        this.attachement = attachement;
        this.article = article;
        this.quantiteeRealisee = quantiteeRealisee;
    }

    public ArticleRealisee() {

    }
}
