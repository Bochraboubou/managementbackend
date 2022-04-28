package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class MaterielLivreePro {
    @EmbeddedId
    private  MaterielLivreeId id;
   @NotNull
    private  float quantiteeLivree;
    @NotNull
    private float prix;


    @JsonIgnore
    @ManyToOne
    @MapsId("bonLivraison_id") //This is the name of attr in Article realiseePK class
    @JoinColumn(name = "bonLivraison_id")
    private BonLivraisonProjet bonLivraisonProjet;

    @JsonIgnore
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    private Article article;
}
