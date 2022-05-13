package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "articlerealiseeMC")
public class ArticleRealiseeMC {
    @EmbeddedId
    private  ArticleRealiseeMCId id;


    @JsonIgnore
    @ManyToOne
    @MapsId("attachementMC_id") //This is the name of attr in Article realiseeMCPK class
    @JoinColumn(name = "attachementMC_id")
    private AttachementMC attachementMC;


    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private float quantiteeRealisee;


    public ArticleRealiseeMC(AttachementMC attachementMC, Article article, float quantiteeRealiseeMC) {
        // create primary key
        this.id = new ArticleRealiseeMCId(attachementMC.getId(), article.getId());

        // initialize attributes
        this.attachementMC = attachementMC;
        this.article = article;
        this.quantiteeRealisee = quantiteeRealiseeMC;
    }



}
