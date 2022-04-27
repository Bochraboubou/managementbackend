package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ordreDefinitif")
public class OrdreDefinitif {
    @EmbeddedId
    private  OrdreDefinitifId id;



    @JsonIgnore
    @ManyToOne
    @MapsId("ordreDeTraveaux_id") //This is the name of attr in ordreDefinitifPK class
    @JoinColumn(name = "ordreDeTraveaux_id")
    private OrdreDeTraveaux ordreDeTraveaux;


    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    private long quantiteeOrderee;


    public OrdreDefinitif(OrdreDeTraveaux ordreDeTraveaux, Article article, long quantiteeOrderee) {
        // create primary key
        this.id = new OrdreDefinitifId(ordreDeTraveaux.getId(), article.getId());

        // initialize attributes
        this.ordreDeTraveaux = ordreDeTraveaux;
        this.article = article;
        this.quantiteeOrderee = quantiteeOrderee;
    }


    public OrdreDefinitif() {

    }
}
